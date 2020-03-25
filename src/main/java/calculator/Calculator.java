package calculator;

public class Calculator {

    private final int result;

    public Calculator(String input) {
        this.result = Integer.parseInt(input);
    }

    public int getResult() {
        return result;
    }

}
