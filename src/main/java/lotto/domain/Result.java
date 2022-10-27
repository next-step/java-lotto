package lotto.domain;

public class Result {
    private final Ranks ranks;
    private final Double rateOfReturn;

    public Result(Ranks ranks, Double rateOfReturn) {
        this.ranks = ranks;
        this.rateOfReturn = rateOfReturn;
    }

    public Ranks getRanks() {
        return ranks;
    }

    public Double getRateOfReturn() {
        return rateOfReturn;
    }
}
