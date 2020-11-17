package step02.domain;

import java.util.Objects;

public class WinningStatistic {
    private final Lotto winningNumbers;

    private WinningStatistic(Lotto winningNumbers) {
        this.winningNumbers = winningNumbers;
    }
    public static WinningStatistic of(Lotto winningNumbers) {
        return new WinningStatistic(winningNumbers);
    }

    public int getMatchCount() {
        return 0;
    }

    public int getReward() {
        return 0;
    }

    public int getTarget() {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningStatistic that = (WinningStatistic) o;
        return Objects.equals(winningNumbers, that.winningNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumbers);
    }
}
