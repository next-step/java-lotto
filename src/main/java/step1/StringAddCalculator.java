package step1;

public class StringAddCalculator {
    String input;

    public StringAddCalculator(String input) {
        this.input = input;
    }

    int calculate() {
        return 0;
    }

    public boolean isBlank(String expression) {
        if (expression == null || expression.isEmpty()) {
            return true;
        }
        return false;
    }

    public boolean isOneLengthNumber(String expression) {
        if (expression.length() == 1 && isNumeric(expression)) {
            return true;
        }
        return false;
    }

    private boolean isNumeric(String expression) {
        try {
            Double.parseDouble(expression);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
