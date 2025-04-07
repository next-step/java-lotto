package step2.winning;

import step2.lottery.LotteryNumber;

import java.util.HashSet;
import java.util.Set;

public class PrizeWinningNumber {
    private final Set<LotteryNumber> prizeWinningNumbers;
    private final LotteryNumber bonusNumber;
    private static final int LOTTO_LENGTH = 6;
    private static final String DELIMITER = ",";

    public PrizeWinningNumber(String input, int number) {
        String[] parsedInput = validateInput(input);
        prizeWinningNumbers = parseNumbers(parsedInput);
        bonusNumber = LotteryNumber.of(number);
        validateBonusNumber(prizeWinningNumbers, bonusNumber);
    }

    public int matchCount(Set<LotteryNumber> lottoNumbers) {
        return (int) prizeWinningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }
    public boolean isMatchBounus(Set<LotteryNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

    private String[] validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("당첨 번호가 입력되지 않았습니다.");
        }
        String[] result = input.replace(" ", "").split(DELIMITER);
        if (result.length != LOTTO_LENGTH) {
            throw new IllegalArgumentException("당첨 번호의 개수가 올바르지 않습니다.");
        }
        return result;
    }

    private Set<LotteryNumber> parseNumbers(String[] result) {
        Set<LotteryNumber> numbers = new HashSet<>();
        for (String number : result) {
            try {
                numbers.add(LotteryNumber.of(Integer.parseInt(number)));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("당첨 번호가 숫자가 아닙니다.");
            }
        }
        if (numbers.size() != LOTTO_LENGTH) {
            throw new IllegalArgumentException("당첨 번호는 중복되지 않는 6개의 숫자여야 합니다.");
        }
        return numbers;
    }

    private void validateBonusNumber(Set<LotteryNumber> numbers, LotteryNumber bonus) {
        if (numbers.contains(bonus)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호와 중복됩니다.");
        }
    }
}
