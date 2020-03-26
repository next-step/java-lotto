package stringcalculator;

import java.util.Objects;

public class StringCalculator {
    private static final String DELIMITER = ",|:";

    private void validExpression(String expression) {

    }

    public int calculate(String expression) {
        if (isNullAndEmpty(expression)) {
            return 0;
        }

        String[] tokens= expression.split(DELIMITER);
        int sum = 0;
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException();
            }
            sum += number;
        }

        return sum;
    }

    private boolean isNullAndEmpty(String expression) {
        if (Objects.isNull(expression) || expression.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
