package first.robot.mechanisms;

import org.wpilib.command3.Command;
import org.wpilib.command3.Coroutine;
import org.wpilib.command3.Mechanism;
import first.robot.CommandFactory;

public class Clock implements Mechanism {
  public int count = 0;

  /**
   * Iterate
   * - invocation prints the clock state and iterates
   */
  private final class Iterate implements CommandFactory {
    /**
     * Command names.
     *
     * @return the resulting string
     */
    @Override
    public String commandName() {
      return "iterate";
    }

    /**
     * Command runs.
     *
     * @param coroutine coroutine
     */
    @Override
    public void commandRun(Coroutine coroutine) {
      int i = 0;
      while (i < 10) {
        System.out.println(i);
        i++;
        coroutine.yield();
      }
    }
  }

  public Command iterate = new Iterate().commandInvoke();
  public Command timed_iterate = new Iterate().timedCommandInvoke("Timed Command Test");
}
