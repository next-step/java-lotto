package lotto.model;

import java.util.List;

public class GameResult {
    private EarningRate earningRate;
    private Results results;

    public GameResult(List<Rank> ranks) {
        this.earningRate = new EarningRate(Rank.findEarningRate(ranks));
        this.results = Results.reflectAll(ranks);
    }

    public double getEarningRate() {
        return earningRate.getEarningRate();
    }

    public Results getResults() {
        return results;
    }
}