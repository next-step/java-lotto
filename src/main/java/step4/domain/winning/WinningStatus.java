package step4.domain.winning;

import step4.exception.InputNegativeAmountException;

public final class WinningStatus {

    public static final int ZERO = 0;

    private final int countOfMatch;
    private final boolean matchBonus;

    private WinningStatus(int countOfMatch, boolean matchBonus) {
        validateNegative(countOfMatch);
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    public static final WinningStatus from(int countOfMatch, boolean matchBonus) {
        return new WinningStatus(countOfMatch, matchBonus);
    }

    private final void validateNegative(int countOfMatch) {
        if (countOfMatch < ZERO) {
            throw new InputNegativeAmountException();
        }
    }

    public final int getCountOfMatch() {
        return countOfMatch;
    }

    public final boolean getMatchBonus() {
        return matchBonus;
    }
}
