package game.lotto.model;

import java.util.EnumMap;
import java.util.Map;

public class MatchResult {

    private final Map<MatchType, Match> matchs = new EnumMap<>(MatchType.class);

    public MatchResult() {
        matchs.put(MatchType.MATCH_3, new Match(MatchType.MATCH_3));
        matchs.put(MatchType.MATCH_4, new Match(MatchType.MATCH_4));
        matchs.put(MatchType.MATCH_5, new Match(MatchType.MATCH_5));
        matchs.put(MatchType.MATCH_6, new Match(MatchType.MATCH_6));
    }


    public void incrementMatch(int matchCount) {
        if(MatchType.containsKey(matchCount)) {
            matchs.compute(
                MatchType.valueOf(matchCount),
                (matchType, match) -> {
                    match.plusCount();
                    return match;
                }
            );
        }
    }

    public Match getMatch(MatchType matchType) {
        return new Match(matchs.get(matchType));
    }

    public long getTotalPrize() {
        return matchs.values().stream().mapToLong(Match::getTotalPrize).sum();
    }

    public Report makeReport(Money purchaseMoney) {
        return new Report(this, purchaseMoney);
    }
}
