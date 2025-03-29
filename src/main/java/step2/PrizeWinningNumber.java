package step2;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class PrizeWinningNumber {
    private final List<LotteryNumber> prizeWinningNumbers;
    private static final String DELIMITER = ",";
    private static final int LOTTO_LENGTH = 6;

    public PrizeWinningNumber(String input) {
        prizeWinningNumbers = validatePrizeWinningNumbers(validateInput(input));
    }

    public WinningResults match(Lotterys lotterys) {
        Map<Winning, Integer> prizeAmounts = initializePrizeAmounts();
        for (int i = 0; i < lotterys.length(); i++) {
            int matchCount = lotterys.getLottery(i).match(prizeWinningNumbers);
            prizeAmounts.put(Winning.valueOf(matchCount), prizeAmounts.get(Winning.valueOf(matchCount)) + 1);
        }
        return new WinningResults(prizeAmounts);
    }

    private Map<Winning, Integer> initializePrizeAmounts() {
        Map<Winning, Integer> prizeAmounts = new EnumMap<>(Winning.class);
        for (Winning winning : Winning.values()) {
            prizeAmounts.put(winning, 0);
        }
        return prizeAmounts;
    }

    private String[] validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
        String[] result = input.replace(" ", "").split(DELIMITER);
        if (LOTTO_LENGTH != result.length) {
            throw new IllegalArgumentException("당첨 결과의 개수가 올바르지 않습니다.");
        }
        return result;
    }

    private List<LotteryNumber> validatePrizeWinningNumbers(String[] result) {
        List<LotteryNumber> numbers = new ArrayList<>();
        for (String number : result) {
            try {
                numbers.add(new LotteryNumber(Integer.parseInt(number)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 결과가 숫자가 아닙니다.");
            }
        }
        if (numbers.stream().distinct().count() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        return numbers;
    }
}
