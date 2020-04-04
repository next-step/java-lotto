package lotto.model.gameresult;

import lotto.model.Rank;

import java.util.List;

public class GameResult {
    private EarningRate earningRate;
    private MatchResults matchResults;

    public GameResult(List<Rank> ranks) {
        this.earningRate = new EarningRate(Rank.findEarningRate(ranks));
        this.matchResults = MatchResults.reflectAll(ranks);
    }

    public double getEarningRate() {
        return earningRate.getEarningRate();
    }

    public MatchResults getMatchResults() {
        return matchResults;
    }
}