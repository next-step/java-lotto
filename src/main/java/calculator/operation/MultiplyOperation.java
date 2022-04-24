package calculator.operation;

public class MultiplyOperation implements Operation {

    @Override
    public int operate(int targetNumber, int number) {
        return targetNumber * number;
    }
}
