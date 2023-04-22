package calculator.state;


import calculator.operation.Operations;

public class InOperationState implements State {

    private final int number;
    private final Operations operation;

    public InOperationState(int number, Operations operation) {
        this.number = number;
        this.operation = operation;
    }

    @Override
    public State next(String input) {
        int number = Integer.parseInt(input);
        int result = operation.apply(this.number, number);
        return new CompleteState(result);
    }

    @Override
    public int value() {
        throw new IllegalStateException("calculation is not completed");
    }
}
