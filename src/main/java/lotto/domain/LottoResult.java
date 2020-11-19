package lotto.domain;

public enum LottoResult {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0);

    private final int winningCount;
    private final int prize;

    private LottoResult(int winningCount, int prize) {
        this.winningCount = winningCount;
        this.prize = prize;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getPrize() {
        return prize;
    }
}
