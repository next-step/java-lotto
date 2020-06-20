package step3;

public class LottoResult {
    private final int winningCount;
    private final boolean hasBonus;

    public LottoResult(int winningCount, boolean hasBonus) {
        this.winningCount = winningCount;
        this.hasBonus = hasBonus;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public boolean hasBonus() {
        return hasBonus;
    }
}
