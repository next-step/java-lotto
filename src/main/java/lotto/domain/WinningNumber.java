package lotto.domain;

import java.util.Objects;

public class WinningNumber {

    private final Ticket winningNumber;
    private static final int LOTTO_COUNT = 6;

    public WinningNumber(Ticket winningNumber) throws IllegalArgumentException {
        validateWinningNumber(winningNumber);
        this.winningNumber = winningNumber;
    }

    public Ticket getWinningNumber() {
        return winningNumber;
    }

    private void validateWinningNumber(Ticket winningNumber) throws IllegalArgumentException {
        if (winningNumber.getLottoSize() != LOTTO_COUNT || !winningNumber.isNumberUnique()) {
            throw new IllegalArgumentException();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningNumber that = (WinningNumber) o;
        return Objects.equals(winningNumber, that.winningNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningNumber);
    }
}
