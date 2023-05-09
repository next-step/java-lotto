package step2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;

public enum MatchCount {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000),
    NONE(0, 0);

    private final int matchCount;
    private final Money prize;

    MatchCount(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = Money.of(prize);
    }

    public static MatchCount of(int matchCount) {
         return Arrays.stream(values())
                 .filter(e -> e.matchCount == matchCount)
                 .findAny()
                 .orElse(NONE);
    }

    public static Map<MatchCount, Long> initializeResults() {
        final Map<MatchCount, Long> results = new LinkedHashMap<>();
        Arrays.stream(MatchCount.values())
                .sorted(Comparator.comparing(MatchCount::getMatchCount))
                .forEach(matchCount -> results.putIfAbsent(matchCount, 0L));
        return results;
    }

    public int getPrize() {
        return prize.toIntValue();
    }

    public int getMatchCount() {
        return matchCount;
    }
}
