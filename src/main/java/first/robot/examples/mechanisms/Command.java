package first.robot.examples.mechanisms;

import org.wpilib.command3.Coroutine;
import first.robot.CommandFactory;

/**
 *  example code of CommandFactory implimentation
 */
public class Command implements CommandFactory {
  @Override
  public String commandName() {
    return "this is a test command name";
  }

  @Override
  public void commandRun(Coroutine coroutine) {
    System.out.println("hello world!");
  }

  @Override
  public org.wpilib.command3.Command commandInvoke() {
    return CommandFactory.super.commandInvoke();
  }
}
