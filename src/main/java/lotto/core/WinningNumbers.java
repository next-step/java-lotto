package lotto.core;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers(String winningNumbersString) {
        String tempWinningNumbersString = winningNumbersString.replace(" ", "");
        String[] tempWinningNumbers = tempWinningNumbersString.split(",");
        this.winningNumbers = Arrays.stream(tempWinningNumbers)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
