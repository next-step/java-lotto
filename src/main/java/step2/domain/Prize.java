package step2.domain;


public class Prize {

    private final Money winningMoney;

    private final Rank rank;

    public Prize(Rank rank) {
        this.rank = rank;
        this.winningMoney = rank.getWinningMoney();
    }

    public Rank getPrizeRank() {
        return rank;
    }

    public static Prize emptyPrize() {
        return new Prize(Rank.MISS);
    }

}
