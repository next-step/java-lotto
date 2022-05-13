package calculator.domain.operation;

public class Multiplication {

    private final int result;

    public Multiplication(int num1, int num2) {
        result = num1 * num2;
    }

    public int getResult() {
        return result;
    }

}
