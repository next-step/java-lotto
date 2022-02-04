package lotto.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoValidator extends Validator {

    private static final int LOTTO_NUMBERS_SIZE = 6;
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;

    private LottoValidator() {
        super();
    }

    public static List<Integer> validateNumbers(String input) {
        final List<Integer> winningNumbers = Arrays.stream(input.split(","))
            .map(number -> parseToInt(number.trim())).collect(Collectors.toList());

        validateRange(winningNumbers);
        validateDuplicateWinning(winningNumbers);
        validateSize(winningNumbers);

        return winningNumbers;
    }

    public static int validateBonus(String input, List<Integer> winningNumbers) {
        final int bonusNumber = parseToInt(input);
        validateRange(bonusNumber);
        validateDuplicateBonus(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateDuplicateWinning(List<Integer> winningNumbers) {
        final List<Integer> deleteDuplicateNumbers = winningNumbers.stream().distinct()
            .collect(Collectors.toList());
        if (winningNumbers.size() != deleteDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

    private static void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new IllegalArgumentException("[ERROR] 번호는 " + LOTTO_NUMBERS_SIZE + "개여야 합니다.");
        }
    }

    private static void validateRange(List<Integer> winningNumbers) {
        winningNumbers.forEach(LottoValidator::validateRange);
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
