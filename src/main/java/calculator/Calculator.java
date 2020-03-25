package calculator;

public class Calculator {

    private final int result;

    public Calculator(String input) {
        this.result = Integer.parseInt(checkNumber(input));
    }

    private String checkNumber(String input) {
        return isNull(isEmpty(input));
    }

    private String isNull(String input) {
        if (input == null) {
            return "0";
        }
        return input;
    }

    private String isEmpty(String input) {
        if (input.isEmpty()) {
            return "0";
        }
        return input;
    }


    public int getResult() {
        return result;
    }

}
