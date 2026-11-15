package first.robot;

/**
 * interface for Triggers that can be set via simulation code
 * SimTrigger
 */
import java.util.function.BooleanSupplier;
import org.jspecify.annotations.NonNull;
import org.wpilib.tunable.TunableBoolean;
import dev.doglog.DogLog;

public class SimTrigger {
  private TunableBoolean state;
  @NonNull String name;

  /**
   * Constructs a new sim trigger instance with the specified parameters.
   *
   * @param defaultState state
   * @param name logged to DogLog
   */
  SimTrigger(boolean defaultState, @NonNull String name) {
    state = TunableBoolean.create(defaultState);
    this.name = name;
    this.state = DogLog.tunable(this.name, defaultState);
  }

  /**
   * flip state
   */
  public void flip() {
    state.set(!state.getAsBoolean());
  }

  /**
   * sets state
   * @param value state
   */
  public void set(boolean value) {
    state.set(value);
  }

  /**
   * returns the supplier that Trigger wants
   *
   * @return the resulting boolean supplier
   */
  BooleanSupplier call() {
    return () -> state.getAsBoolean();
  }
}
