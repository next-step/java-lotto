package lotto.domain;

import java.util.Arrays;

public enum WinningInformation {

    FIRST(new MatchingResult(6, false), 2_000_000_000),
    SECOND(new MatchingResult(5, true), 30_000_000),
    THIRD(new MatchingResult(5, false), 1_500_000),
    FOURTH(new MatchingResult(4, false), 50_000),
    FIFTH(new MatchingResult(3, false), 5_000),
    NO_PRIZE(new MatchingResult(0, false), 0);

    private final MatchingResult matchingResult;
    private final long prizeMoney;

    WinningInformation(final MatchingResult matchingResult, final long prizeMoney) {
        this.matchingResult = matchingResult;
        this.prizeMoney = prizeMoney;
    }

    public static WinningInformation findByMatchingResult(final MatchingResult matchingResult) {
        return Arrays.stream(values())
            .filter(wi -> wi.matchingResult.equals(matchingResult))
            .findFirst()
            .orElse(NO_PRIZE);
    }

    public int getCountOfMatchedNumber() {
        return matchingResult.getCountOfMatchedNumber();
    }

    public boolean isContainedBonus() {
        return matchingResult.isContainedBonus();
    }

    public long getPrizeMoney() {
        return prizeMoney;
    }
}
