package calculator.operation;

public class MinusOperation implements Operation {

    @Override
    public int operate(int targetNumber, int number) {
        return targetNumber - number;
    }
}
