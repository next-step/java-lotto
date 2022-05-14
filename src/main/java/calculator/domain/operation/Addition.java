package calculator.domain.operation;

public class Addition {

    private final int result;

    public Addition(int num1, int num2) {
        result = num1 + num2;
    }

    public int getResult() {
        return result;
    }

}
