package lottos.domain;

import java.util.Arrays;

public enum WinningPrize {

    ZERO(0, 0),
    ONE(0, 1),
    TWO(0, 2),
    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6);

    private final Integer prizeAmount;
    private final Integer numberOfMatches;

    WinningPrize(Integer prizeAmount, Integer numberOfMatches) {
        this.prizeAmount = prizeAmount;
        this.numberOfMatches = numberOfMatches;
    }

    public static WinningPrize findByNumberOfMatchers(int count) {
        return Arrays.stream(WinningPrize.values())
                .filter(r -> r.numberOfMatches == count)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Integer getNumberOfMatches() {
        return numberOfMatches;
    }

    public Integer getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isWinning() {
        return this.prizeAmount > 0;
    }
}
