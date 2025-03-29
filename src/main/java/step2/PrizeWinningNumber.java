package step2;

import java.util.ArrayList;
import java.util.List;

public class PrizeWinningNumber {
    private final List<LotteryNumber> prizeWinningNumbers;
    private static final String DELIMITER = ",";
    private static final int LOTTO_LENGTH = 6;

    public PrizeWinningNumber(String input) {
        prizeWinningNumbers = validatePrizeWinningNumbers(input);
    }

    public List<Integer> getPrizeWinningNumbers() {
        return prizeWinningNumbers;
    }
    private List<Integer> validatePrizeWinningNumbers(String input) {
        List<Integer> numbers = new ArrayList<>();
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
        String[] result = input.replace(" ", "").split(DELIMITER);
        if (LOTTO_LENGTH != result.length) {
            throw new IllegalArgumentException("당첨 결과의 개수가 올바르지 않습니다.");
        }
        for (int i = 0; i < result.length; i++) {
            try {
                int matchCount = Integer.parseInt(result[i]);
                if (matchCount < MIN_NUMBER || matchCount > MAX_NUMBER) {
                    throw new IllegalArgumentException("당첨 번호의 범위가 올바르지 않습니다.");
                }
                numbers.add(matchCount);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 결과가 숫자가 아닙니다.");
            }
        }
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
        return numbers;
    }
}
