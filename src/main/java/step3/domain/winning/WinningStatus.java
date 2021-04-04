package step3.domain.winning;

import step3.exception.InputNegativeAmountException;

public final class WinningStatus {

    private static final int ZERO = 0;

    private final int countOfMatch;
    private final boolean matchBonus;

    private WinningStatus(int countOfMatch, boolean matchBonus) {
        validateNegative(countOfMatch);
        this.countOfMatch = countOfMatch;
        this.matchBonus = matchBonus;
    }

    private final void validateNegative(int countOfMatch) {
        if(countOfMatch < ZERO) {
            throw new InputNegativeAmountException();
        }
    }


    public static final WinningStatus from(int countOfMatch, boolean matchBonus) {
        return new WinningStatus(countOfMatch, matchBonus);
    }

}
