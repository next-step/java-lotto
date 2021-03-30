package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final static String DEFAULT_REGEX = ",";
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public WinningNumber(String winningNumber, int bonusNumber) {
        String[] splitWinningNumbers = winningNumber.split(DEFAULT_REGEX);
        this.winningNumbers = Arrays.stream(splitWinningNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        this.bonusNumber = bonusNumber;
    }

    public boolean contains(int lotto) {
        return winningNumbers.contains(lotto);
    }

    public boolean isMatchBonus(int lotto){
        return bonusNumber == lotto;
    }
}
