package step2;

import static step2.NotPositiveNumberException.CHARACTER_OR_NEGATIVE_NUMBER_ERROR;

public class PositiveNumber {
    private static final int ZERO_NUMBER = 0;
    private final int positiveNumber;

    public PositiveNumber(String number) {
        validatePositiveNumber(number);
        this.positiveNumber = Integer.parseInt(number);
    }

    public int add(int addValue) {
        return addValue + positiveNumber;
    }

    private static void validatePositiveNumber(String splitNumbers) {
        validateNumberIsDigit(splitNumbers);
        minusNumberCheck(splitNumbers);
    }

    private static void validateNumberIsDigit(String splitNumbers) {
        if (!splitNumbers.chars().allMatch(Character::isDigit)) {
            throw new NotPositiveNumberException(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
        }
    }

    private static void minusNumberCheck(String splitNumbers) {
        if (Integer.parseInt(splitNumbers) < ZERO_NUMBER) {
            throw new RuntimeException(CHARACTER_OR_NEGATIVE_NUMBER_ERROR);
        }
    }


}
