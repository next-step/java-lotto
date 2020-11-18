package step1.calculator;

import java.util.Objects;

/**
 * Created By mand2 on 2020-11-19.
 */
public class PositiveNumber {

    private final int positiveNumber;
    private static final String MESSAGE_NUMBER_OVER_ZERO = "입력한 값은 0 이상의 정수여야 합니다.";
    private static final int ZERO = 0;

    private PositiveNumber(int positiveNumber) {
        this.positiveNumber = positiveNumber;
    }

    public static PositiveNumber of(String inputNumber) {
        int positiveNumber = checkPositiveNumber(inputNumber);

        return new PositiveNumber(positiveNumber);
    }

    private static int checkPositiveNumber(String inputNumber) {
        int number = isNumber(inputNumber);
        isUnderZero(number);

        return number;
    }

    private static int isNumber(String inputNumber) {
        try {
            return Integer.valueOf(inputNumber);
        } catch (NumberFormatException e) {
            throw new RuntimeException(MESSAGE_NUMBER_OVER_ZERO);
        }
    }

    private static void isUnderZero(int number) {
        if (ZERO > number) {
            throw new RuntimeException(MESSAGE_NUMBER_OVER_ZERO);
        }
    }

    public int value() {
        return this.positiveNumber;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PositiveNumber that = (PositiveNumber) o;
        return positiveNumber == that.positiveNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(positiveNumber);
    }

    @Override
    public String toString() {
        return String.valueOf(positiveNumber);
    }
}
