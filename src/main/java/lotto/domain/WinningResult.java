package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningResult {
    private final List<Integer> winningResult;

    WinningResult(List<Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public int getTotalWinningMoney() {
        int total = 0;

        Prize[] prizes = Prize.values();
        for (Prize prize : prizes) {
            total += prize.winningMoney(winningResult.get(prize.index()));
        }

        return total;
    }

    public List<Integer> getWinningResult() {
        return winningResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningResult that = (WinningResult) o;
        return Objects.equals(winningResult, that.winningResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningResult);
    }
}
