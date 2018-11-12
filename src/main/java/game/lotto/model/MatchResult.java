package game.lotto.model;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchResult {

    private final Map<Rank, Match> matchs;

    public MatchResult() {
        matchs = Arrays.stream(Rank.values())
                .collect(
                        Collectors.toMap(
                                matchType -> matchType,
                                Match::new,
                                (before, after) -> before,
                                () -> new EnumMap<>(Rank.class)
                        )
                );
    }


    public Match getMatch(Rank rank) {
        return new Match(matchs.get(rank));
    }

    public long getTotalPrize() {
        return matchs.values().stream().mapToLong(Match::getTotalPrize).sum();
    }

    public Report makeReport(Money purchaseMoney) {
        return new Report(this, purchaseMoney);
    }

    public void plus(Match match) {
        matchs.computeIfPresent(
                match.getRank(),
                (key, value) -> {
                    value.plusCount();
                    return value;
                }
        );
    }
}
