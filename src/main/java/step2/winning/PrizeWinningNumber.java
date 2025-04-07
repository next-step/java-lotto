package step2.winning;

import step2.lottery.LotteryNumber;
import step2.winning.WinningNumberValidator;

import java.util.Set;

public class PrizeWinningNumber {
    private final Set<LotteryNumber> prizeWinningNumbers;
    private final LotteryNumber bonusNumber;

    public PrizeWinningNumber(String input, int number) {
        String[] parsedInput = WinningNumberValidator.validateInput(input);
        prizeWinningNumbers = WinningNumberValidator.parseNumbers(parsedInput);
        bonusNumber = new LotteryNumber(number);
        WinningNumberValidator.validateBonusNumber(prizeWinningNumbers, bonusNumber);
    }

    public int matchCount(Set<LotteryNumber> lottoNumbers) {
        return (int) prizeWinningNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }
    public boolean isMatchBounus(Set<LotteryNumber> lottoNumbers) {
        return lottoNumbers.contains(bonusNumber);
    }

}
