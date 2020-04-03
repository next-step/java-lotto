package lotto.model;

import java.util.List;

public class GameResult {
    private double earningRate;
    private Results results;

    public GameResult(List<Rank> ranks) {
        this.earningRate = Rank.findEarningRate(ranks);
        this.results = Results.reflectAll(ranks);
    }

    public double getEarningRate() {
        return earningRate;
    }

    public Results getResults() {
        return results;
    }
}
