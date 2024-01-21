interface SwitchState {
void turnOn();
void turnOff();
void energySaving();
}
class OnState implements SwitchState {
private static final OnState onStateInstance = new OnState();
private OnState() {
}

public static OnState getOnStateInstance() {
    return onStateInstance;
}

@Override
public void turnOn() {
    System.out.println("The switch is already ON.");
}

@Override
public void turnOff() {
    System.out.println("Turning OFF the switch.");
}

@Override
public void energySaving() {
    System.out.println("Switching to energy-saving mode.");
}

}
class OffState implements SwitchState {
private static final OffState offStateInstance = new OffState();

private OffState() {
}

public static OffState getOffStateInstance() {
    return offStateInstance;
}

@Override
public void turnOn() {
    System.out.println("Turning ON the switch.");
}

@Override
public void turnOff() {
    System.out.println("The switch is already OFF.");
}

@Override
public void energySaving() {
    System.out.println("Energy-saving mode is not available when the switch is OFF.");
}

}
class EnergySavingState implements SwitchState {
private static final EnergySavingState energySavingStateInstance = new EnergySavingState();

private EnergySavingState() {
}

public static EnergySavingState getEnergySavingInstance() {
    return energySavingStateInstance;
}

@Override
public void turnOn() {
    System.out.println("Turning ON the switch from energy-saving mode.");
}

@Override
public void turnOff() {
    System.out.println("Turning OFF the switch from energy-saving mode.");
}

@Override
public void energySaving() {
    System.out.println("The switch is already in energy-saving mode.");
}

}

// Context (smart switch)
class SmartSwitch {
private SwitchState currentState;

public SmartSwitch() {
    currentState = OffState.getOffStateInstance();
}

public void setState(SwitchState state) {
    currentState = state;
}

public void turnOn() {
    currentState.turnOn();
    setState(OnState.getOnStateInstance());
}

public void turnOff() {
    currentState.turnOff();
    setState(OffState.getOffStateInstance());
}

public void energySaving() {
    currentState.energySaving();
    setState(EnergySavingState.getEnergySavingInstance());
}

}

public class Main {
public static void main(String[] args) {
SmartSwitch smartSwitch = new SmartSwitch();

    smartSwitch.turnOn();
    smartSwitch.energySaving();
    smartSwitch.turnOff();
    smartSwitch.turnOn();
}

}