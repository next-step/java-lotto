package lotto.objects;

public enum WinningType {
    THREE("3개 일치 (5000원)", 5_000, 3),
    FOUR("4개 일치 (50000원)", 50_000, 4),
    FIVE("5개 일치 (1500000원)", 1_500_000, 5),
    FIVE_AND_BONUS("5개 일치, 보너스 볼 일치 (30000000원)", 30_000_000, 6),
    SIX("6개 일치 (2000000000원)", 2_000_000_000, 6),
    LOSE("꽝", 0, 0);

    private String correspond;
    private int winningAmount;
    private int counts;

    WinningType(String correspond, int winningAmount, int counts) {
        this.correspond = correspond;
        this.winningAmount = winningAmount;
        this.counts = counts;
    }

    public String getCorrespond() {
        return correspond;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public int getCounts() {
        return counts;
    }
}
