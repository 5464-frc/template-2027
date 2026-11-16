package first.robot.examples.mechanisms;

import org.wpilib.command3.Coroutine;
import first.robot.CommandFactory;

/**
 *  example code of CommandFactory implimentation
 */
public class Command implements CommandFactory {
  /**
   * Set command name
   *
   * @return the resulting string
   */
  @Override
  public String commandName() {
    return "this is a test command name";
  }

  /**
   * function to run when command is triggered
   *
   * @param coroutine coroutine
   */
  @Override
  public void commandRun(Coroutine coroutine) {
    System.out.println("hello world!");
  }

  /**
   * interface for the actual command
   *
   * @return the resulting org.wpilib.command3.command
   */
  @Override
  public org.wpilib.command3.Command commandInvoke() {
    return CommandFactory.super.commandInvoke();
  }
}
