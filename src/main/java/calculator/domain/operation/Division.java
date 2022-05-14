package calculator.domain.operation;

public class Division {

    private final int result;

    public Division(int num1, int num2) {
        result = num1 / num2;
    }

    public int getResult() {
        return result;
    }

}
