package calculator.state;

public class InitialState implements State {
    @Override
    public State next(String input) {
        int number = Integer.parseInt(input);
        return new CompleteState(number);
    }

    @Override
    public int value() {
        throw new IllegalStateException("calculation is not completed");
    }
}
