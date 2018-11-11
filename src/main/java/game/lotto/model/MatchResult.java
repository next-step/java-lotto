package game.lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchResult {

    private final Map<MatchType, Match> matchs;

    public MatchResult() {
        matchs = Arrays.stream(MatchType.values())
                .collect(
                        Collectors.toMap(
                                matchType -> matchType,
                                Match::new,
                                (before, after) -> before,
                                () -> new EnumMap<>(MatchType.class)
                        )
                );
    }


    public void incrementMatch(int matchCount) {
        MatchType matchType = MatchType.valueOf(matchCount);
        matchs.computeIfPresent(
                matchType,
                (key, match) -> {
                    match.plusCount();
                    return match;
                }
        );
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
