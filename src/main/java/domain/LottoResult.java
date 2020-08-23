package domain;

public class LottoResult {
    private final Rank rank;
    private final Prize prize;

    private LottoResult(Rank rank, Prize winningCountr) {
        this.rank = rank;
        this.prize = winningCountr;
    }

    public static LottoResult of(Rank rank) {
        return new LottoResult(rank, Prize.of());
    }

    public long getWinningMoney() {
        return prize.getWinningMoney();
    }

    public void win(Rank rank) {
        if (!isSameRank(rank)) {
            return;
        }

        prize.increase(rank.getMoney());
    }

    public int getWinningCount() {
        return prize.getWinningCount();
    }

    public int getPrizeHitNumber() {
        return rank.getHitNumber();
    }

    public int getPrizeMoney() {
        return rank.getMoney();
    }

    public boolean isSameRank(Rank target) {
        return rank.equals(target);
    }
}
