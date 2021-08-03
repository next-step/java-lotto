package lottos.domain;

import java.util.Objects;

public class Result {

    private WinningPrize winningPrize;

    public Result(WinningPrize winningPrize) {
        this.winningPrize = winningPrize;
    }

    public WinningPrize getWinningPrize() {
        return winningPrize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result that = (Result) o;
        return winningPrize == that.winningPrize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningPrize);
    }
}
