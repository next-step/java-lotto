package lotto.domain;

import java.util.Objects;

public class WinningAmount {
    private int winningAmount;

    public WinningAmount() {
        this.winningAmount = 0;
    }

    public WinningAmount(int amount) {
        this.winningAmount = amount;
    }

    public void add(int value) {
        this.winningAmount += value;
    }

    public int amount() {
        return winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningAmount that = (WinningAmount) o;
        return winningAmount == that.winningAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningAmount);
    }
}
