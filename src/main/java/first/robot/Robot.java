// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.
package first.robot;

import org.wpilib.command3.Scheduler;
import org.wpilib.framework.OpModeRobot;
import dev.doglog.DogLog;
import dev.doglog.DogLogOptions;
import first.robot.examples.mechanisms.Clock;

public class Robot extends OpModeRobot {
  public final Clock m_Clock = new Clock();
  public final SimTrigger simTrigger = new SimTrigger(false, "Clock Trigger (sim)");
  public final Trigger clock_trigger = new Trigger(simTrigger.call());

  /**
   * Constructs a new robot instance.
   */
  public Robot() {
    DogLog.setOptions(new DogLogOptions().withCaptureDs(true));

    clock_trigger.onTrue(m_Clock.timed_iterate);
  }

  /**
   * robot periodic code
   */
  @Override
  public void robotPeriodic() {
    Scheduler.getDefault().run();
  }
}
