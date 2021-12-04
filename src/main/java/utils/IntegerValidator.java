package utils;

import java.text.MessageFormat;

public interface IntegerValidator {

    static int getNumberIfRange(int number, int min, int max) {
        if (number < min) {
            throw new IllegalArgumentException(
                MessageFormat.format("입력 숫자가 {0}보다 작을 수 는 없습니다.", min));
        }

        if (number > max) {
            throw new IllegalArgumentException(
                MessageFormat.format("입력 숫자가 {0}보다 클 수 는 없습니다.", max));
        }

        return number;
    }

    static int getNumberIfPositive(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(
                MessageFormat.format("{0}은 양수가 아닙니다.", number)
            );
        }

        return number;
    }

    static boolean isNumberNegative(int number) {
        return !isNumberPositive(number);
    }

    static boolean isNumberPositive(int number) {
        return number >= 0;
    }

}
