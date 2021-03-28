package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumber {
    private final static String DEFAULT_REGEX = ",";
    private final List<Integer> winningNumbers;

    public WinningNumber(String winningNumber) {
        String[] splitWinnigNumbers = winningNumber.split(DEFAULT_REGEX);
        winningNumbers = Arrays.stream(splitWinnigNumbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public boolean contains(int lotto) {
        return winningNumbers.contains(lotto);
    }
}
