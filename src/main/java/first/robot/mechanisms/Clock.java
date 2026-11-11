package first.robot.mechanisms;

import java.util.Set;
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
  public class Iterate implements CommandFactory {
    @Override
    public String commandName() {
      return "iterate";
    }

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
}
