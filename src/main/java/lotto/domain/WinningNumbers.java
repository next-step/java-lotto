package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    List<Integer> winningNumbers;

    public WinningNumbers(String winningNumbers) {
        this.winningNumbers = winningNumbersMake(winningNumbers);;
    }

    public List<Integer> winningNumbersMake(String winningNumbers){
        return Arrays.asList(winningNumbers.split(",")).stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
