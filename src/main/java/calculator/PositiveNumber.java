package calculator;

import static calculator.util.CommonUtil.validateNullEmpty;

public class PositiveNumber {

    private final int number;

    public PositiveNumber(String text) {
        int positiveNumber = 0;
        try {
            validateNullEmpty(text, "argument is null");
            positiveNumber = Integer.parseInt(text);
            validatePositive(positiveNumber);
        } catch (NumberFormatException e) {
          throw new NumberFormatException("Argument is not numberFormat type");
        } catch (IllegalArgumentException ignore) {
            positiveNumber = 0;
        }

        number = positiveNumber;
    }

    public static PositiveNumber of(String s) {
        return new PositiveNumber(s);
    }

    public int getNumber() {
        return number;
    }

    private void validatePositive(int number) throws RuntimeException {
        if (number < 0) {
            throw new RuntimeException(number + "is negative!!");
        }
    }

}
