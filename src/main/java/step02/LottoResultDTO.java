package step02;

public class LottoResultDTO {

    private Ranks ranks = new Ranks();
    private Double yield = 0.0;

    public void setRanks(Ranks ranks) {
        this.ranks = ranks;
    }

    public int getRankFifthCount() { return ranks.getNumberOfEachRank(Rank.FIFTH); }

    public int getRankFourthCount() {
        return ranks.getNumberOfEachRank(Rank.FOURTH);
    }

    public int getRankThirdCount() {
        return ranks.getNumberOfEachRank(Rank.THIRD);
    }

    public int getRankSecondCount() {
        return ranks.getNumberOfEachRank(Rank.SECOND);
    }

    public int getRankFirstCount() {
        return ranks.getNumberOfEachRank(Rank.FIRST);
    }

    public Double getYield() {
        return yield;
    }

    public void setYield(Double yield) {
        this.yield = yield;
    }
}
