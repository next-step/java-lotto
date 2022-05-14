package calculator.domain.operation;

public class Subtraction {

    private final int result;

    public Subtraction(int num1, int num2) {
        result = num1 - num2;
    }

    public int getResult() {
        return result;
    }

}
