package step3.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(int[] winningNumbers) {
        this.winningNumbers = Arrays.stream(winningNumbers)
                .boxed()
                .collect(Collectors.toList());
    }

    public boolean isWinningNumber(int number) {
        return winningNumbers.contains(number);
    }

}
