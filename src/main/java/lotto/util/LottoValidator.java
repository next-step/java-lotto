package lotto.util;

import java.util.List;

public class LottoValidator extends Validator {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    private LottoValidator() {
        super();
    }

    public static int validateBonus(String input, List<Integer> winningNumbers) {
        final int bonusNumber = parseToInt(input);
        validateRange(bonusNumber);
        validateDuplicateBonus(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateRange(int number) {
        if (number < MINIMUM_BALL_NUMBER || number > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_BALL_NUMBER + "부터 " + MAXIMUM_BALL_NUMBER + "까지의 숫자만 입력해주세요.");
        }
    }

    private static void validateDuplicateBonus(int number, List<Integer> winningNumbers) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }
}
