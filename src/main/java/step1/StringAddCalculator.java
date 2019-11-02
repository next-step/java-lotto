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

    public boolean isNegative(int operand) {
        if (operand < 0) {
            throw new IllegalArgumentException("Negative number is not allowed");
        }
        return false;
    }

    public int plus(String[] operands) {
        int result = 0;

        for (String operand : operands) {
            int parsedOperand = Integer.parseInt(operand);

            if(!isNegative(parsedOperand)) {
                result += parsedOperand;
            }
        }

        return result;
    }
}
