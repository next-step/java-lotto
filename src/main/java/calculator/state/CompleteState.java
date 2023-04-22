package calculator.state;


import calculator.operation.Operations;

public class CompleteState implements State {

    private final int number;

    public CompleteState(int number) {
        this.number = number;
    }

    @Override
    public State next(String input) {
        Operations operation = Operations.of(input);
        return new InOperationState(number, operation);
    }

    public int value() {
        return number;
    }

}
