package first.robot;

import java.util.Collections;
import java.util.Set;
import org.wpilib.command3.Command;
import org.wpilib.command3.Coroutine;
import org.wpilib.command3.Mechanism;

/**
 *    work around to having to deal with lambda expressions <br>
 *    specify name, run function, and requireSet before invoking <br>
 *    this is overly verbose relative to the documentation preferred syntax, but is easier to read <br>
 *    implimentation specified in {@link examples/mechanisms/Command.java}
 */
public interface CommandFactory {
  public default Set<Mechanism> requiredSet() {
    return Collections.emptySet();
  }

  public default void commandRun(Coroutine coroutine) {}

  public default String commandName() {
    return ("");
  }

  public default Command commandInvoke() {
    return new Command() {
      public java.util.Set<Mechanism> requirements() {
        return requiredSet();
      }

      public void run(Coroutine coroutine) {
        commandRun(coroutine);
      }

      public String name() {
        return commandName();
      }
    };
  }
}
