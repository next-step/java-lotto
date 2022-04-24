package calculator.operation;

public class DivideOperation implements Operation {

    @Override
    public int operate(int targetNumber, int number) {
        if (number == 0) {
            throw new IllegalArgumentException();
        }

        if (targetNumber % number > 0) {
            throw new IllegalArgumentException();
        }

        return targetNumber / number;
    }
}
