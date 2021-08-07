package lottos.domain;

import lottos.domain.exceptions.NotFoundDataException;

import java.util.Arrays;

public enum Prize {

    ZERO(0, 0),
    ONE(0, 1),
    TWO(0, 2),
    THREE(5000, 3),
    FOUR(50000, 4),
    FIVE(1500000, 5),
    SIX(2000000000, 6);

    private final int prizeAmount;
    private final int numberOfMatches;

    Prize(final int prizeAmount, final int numberOfMatches) {
        this.prizeAmount = prizeAmount;
        this.numberOfMatches = numberOfMatches;
    }

    public static Prize findByNumberOfMatchers(final int count) {
        return Arrays.stream(Prize.values())
                .filter(winningPrize -> winningPrize.numberOfMatches == count)
                .findAny()
                .orElseThrow(NotFoundDataException::new);
    }

    public int getNumberOfMatches() {
        return numberOfMatches;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public boolean isWinning() {
        return this.prizeAmount > 0;
    }
}
