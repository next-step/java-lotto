package step2.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumbers {

    private final List<Integer> winningNumbers;

    public WinningNumbers(List<Integer> input) {
        this.winningNumbers = input;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumbers that = (WinningNumbers) o;
        return Objects.equals(getWinningNumbers(), that.getWinningNumbers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWinningNumbers());
    }
}
