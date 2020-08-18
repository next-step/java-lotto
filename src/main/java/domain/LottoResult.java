package domain;

public class LottoResult {
    private final Rank rank;
    private final WinningCount winningCount;

    private LottoResult(Rank rank, WinningCount winningCountr) {
        this.rank = rank;
        this.winningCount = winningCountr;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank, WinningCount.of());
    }

    public static LottoResult of(Rank rank, int winningCount) {
        return new LottoResult(rank, WinningCount.of(winningCount));
    }

    public int calculateWinningMoney() {
        return winningCount.calculateWinningMoney(rank.getMoney());
    }

    public void win(int hitNumber, boolean matchBonus) {
        if (rank != Rank.valueOf(hitNumber, matchBonus)) {
            return;
        }

        this.winningCount.increase();
    }

    public int getWinningCount() {
        return winningCount.getValue();
    }

    public int getPrizeHitNumber() {
        return rank.getHitNumber();
    }

    public int getPrizeMoney() {
        return rank.getMoney();
    }
}
