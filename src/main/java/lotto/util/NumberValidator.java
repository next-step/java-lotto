package lotto.util;

public class NumberValidator extends Validator {

    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    protected NumberValidator() {
    }

    public static Integer validate(String number) {
        return validateRange(parseToInt(number));
    }

    public static Integer validateRange(Integer number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
        }
        return number;
    }
}
