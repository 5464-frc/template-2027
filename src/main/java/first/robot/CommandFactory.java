package first.robot;

import java.util.Collections;
import java.util.Set;

import org.jspecify.annotations.NonNull;
import org.wpilib.command3.Command;
import org.wpilib.command3.Coroutine;
import org.wpilib.command3.Mechanism;
import org.wpilib.hardware.hal.HALUtil;
import dev.doglog.DogLog;

/**
 * work around to having to deal with lambda expressions <br>
 * specify name, run function, and requireSet before invoking <br>
 * this is overly verbose relative to the documentation preferred syntax, but is easier to read <br>
 * implimentation specified in {@link examples/mechanisms/Command.java}
 */
public interface CommandFactory {
  /**
   * Command requireds.
   *
   * @return set containing mechanisms
   */
  default Set<Mechanism> commandRequired() {
    return Collections.emptySet();
  }

  /**
   * function to be ran on Command call
   *
   * @param coroutine coroutine
   */
  default void commandRun(Coroutine coroutine) {
    // empty by default
  }

  /**
   * return command name
   *
   * @return the resulting string
   */
  default String commandName() {
    return "";
  }

  /**
   * actual Command to be ran
   *
   * @return the resulting command
   */
  default Command commandInvoke() {
    return new Command() {
      public Set<Mechanism> requirements() {
        return commandRequired();
      }

      public void run(Coroutine coroutine) {
        commandRun(coroutine);
      }
      public String name() {
        return commandName();
      }
    };
  }

  /**
   * same as {@link commandInvoke}, but times the Command and logs to DogLog
   * @param key
   * @return
   */
  default Command timedCommandInvoke(@NonNull String key) {
    return new Command() {
      public Set<Mechanism> requirements() {
        return commandRequired();
      }

      public void run(Coroutine coroutine) {
        var startTime = HALUtil.getMonotonicTime();
        coroutine.await(commandInvoke());
        var endTime = HALUtil.getMonotonicTime()-startTime;
        DogLog.log(key, endTime, "nanosecond");
      }
      public String name() {
        return commandName();
      }
    };
  }
}
