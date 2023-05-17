package autolotto.dto;

public class WinningAmount {
    private final int matchCount;
    private final int winningAmount;

    public WinningAmount(int matchCount, int winningAmount) {
        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int matchCount() {
        return matchCount;
    }

    public int winningAmount() {
        return winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WinningAmount)) return false;

        WinningAmount that = (WinningAmount) o;

        if (matchCount != that.matchCount) return false;
        return winningAmount == that.winningAmount;
    }

    @Override
    public int hashCode() {
        int result = matchCount;
        result = 31 * result + winningAmount;
        return result;
    }
}
