package step2.domain;


public class Prize {

    private final Money winningMoney;

    private final Rank rank;

    public Prize(int correctCount) {
        this.rank = Rank.valueOf(correctCount);
        this.winningMoney = rank.getWinningMoney();
    }

    public Rank getPrizeRank() {
        return rank;
    }

}
