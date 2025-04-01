package step2.winning;

import step2.lottery.LotteryNumber;

import java.util.HashSet;
import java.util.Set;

public class WinningNumberValidator {
    private static final int LOTTO_LENGTH = 6;
    private static final String DELIMITER = ",";

    public static String[] validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
        String[] result = input.replace(" ", "").split(DELIMITER);
        if (result.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("당첨 번호의 개수가 올바르지 않습니다.");
        }
        return result;
    }

    public static Set<LotteryNumber> parseNumbers(String[] result) {
        Set<LotteryNumber> numbers = new HashSet<>();
        for (String number : result) {
            try {
                numbers.add(new LotteryNumber(Integer.parseInt(number)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호가 숫자가 아닙니다.");
            }
        }
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        return numbers;
    }

    public static void validateBonusNumber(Set<LotteryNumber> numbers, LotteryNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
