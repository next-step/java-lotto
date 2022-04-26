package calculator.domain.operation;

public class AddOperation implements Operation {

    @Override
    public int operate(int targetNumber, int number) {
        return targetNumber + number;
    }
}
