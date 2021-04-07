package step4.domain.winning;

import step4.exception.InputNegativeAmountException;

public final class WinningStatus {

    public static final long ZERO = 0L;

    private final long countOfMatch;
    private final boolean matchBonus;

    private WinningStatus(long countOfMatch, boolean matchBonus) {
        validateNegative(countOfMatch);
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public static final WinningStatus from(long countOfMatch, boolean matchBonus) {
        return new WinningStatus(countOfMatch, matchBonus);
    }

    private final void validateNegative(long countOfMatch) {
        if (countOfMatch < ZERO) {
            throw new InputNegativeAmountException();
        }
    }

    public final long getCountOfMatch() {
        return countOfMatch;
    }

    public final boolean getMatchBonus() {
        return matchBonus;
    }
}
