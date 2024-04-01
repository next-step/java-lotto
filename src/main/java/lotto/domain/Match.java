package lotto.domain;

import java.util.List;

public class Match {

    private final MatchCache matchCache;
    private final Profit profit;

    public Match() {
        this(new MatchCache(), new Profit(0));
    }

    public Match(MatchCache matchCache, Profit profit) {
        this.matchCache = matchCache;
        this.profit = profit;
    }

    public void save(int matchCount, boolean isBonus) {
        matchCache.save(matchCount, isBonus);
        profit.accumulate(matchCount, isBonus);
    }

    public MatchCache getMatchCache() {
        return matchCache;
    }

    public Profit getProfit() {
        return profit;
    }
}
