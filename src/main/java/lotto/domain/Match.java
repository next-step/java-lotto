package lotto.domain;

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

    public static boolean getCount(List<Integer> sources, Integer bonusNumber) {
        if (sources == null || bonusNumber == null) throw new IllegalArgumentException();
        return sources.stream()
                .anyMatch(bonusNumber::equals);
    }
}
