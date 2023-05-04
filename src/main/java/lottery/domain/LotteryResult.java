package lottery.domain;

import java.util.List;
import java.util.Objects;

public class LotteryResult {
    private final List<Integer> winNumbers;

    public LotteryResult(List<Integer> winNumbers) {
        this.winNumbers = winNumbers;
    }

    @Override
    public String toString() {
        return winNumbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryResult that = (LotteryResult) o;
        return Objects.equals(winNumbers, that.winNumbers);
    }
}
