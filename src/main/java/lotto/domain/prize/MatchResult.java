package lotto.domain.prize;

import java.util.Map;
import java.util.Objects;

public class MatchResult {
    private static final int NO_MATCH_COUNT = 0;
    private final Map<LottoPrize, Long> matchResult;

    public MatchResult(Map<LottoPrize, Long> matchResult) {
        validate(matchResult);
        this.matchResult = matchResult;
    }

    private void validate(Map<LottoPrize, Long> matchResult) {
        if (Objects.isNull(matchResult) || matchResult.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public static MatchResult of(Map<LottoPrize, Long> matchResult) {
        return new MatchResult(matchResult);
    }

    public Map<LottoPrize, Long> getMatchResult() {
        return matchResult;
    }

    public int matchCount(LottoPrize lottoPrize) {
        if (isNotContainsKey(lottoPrize)) {
            return NO_MATCH_COUNT;
        }

        return matchResult.get(lottoPrize)
                .intValue();
    }

    private boolean isNotContainsKey(LottoPrize lottoPrize) {
        return !matchResult.containsKey(lottoPrize);
    }
}
