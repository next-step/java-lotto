package lotto;

import java.util.Objects;

/** 로또 당첨금액을 의미합니다. */
public class WinningAmount {
    private int winningAmount = 0;

    private WinningAmount() {
    }

    public static WinningAmount of(WinningLevel winningLevel) {
        WinningAmount amount = new WinningAmount();

        if (winningLevel == WinningLevel.NONE) {
            amount.winningAmount = 0;
            return amount;
        }

        if (winningLevel == WinningLevel.FIVE) {
            amount.winningAmount = 5000;
            return amount;
        }

        if (winningLevel == WinningLevel.FOUR) {
            amount.winningAmount = 50000;
            return amount;
        }

        if (winningLevel == WinningLevel.THREE) {
            amount.winningAmount = 1500000;
            return amount;
        }

        // 1등
        amount.winningAmount = 2000000000;
        return amount;
    }

    public static WinningAmount of(int winningAmount) {
        if (winningAmount < 0) {
            throw new IllegalArgumentException("당첨 금액은 0보다 작을 수 없으나 " + winningAmount + "이 주어졌습니다.");
        }

        WinningAmount amount = new WinningAmount();
        amount.winningAmount = winningAmount;

        return amount;
    }

    @Override
    public String toString() {
        return "" + winningAmount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        WinningAmount that = (WinningAmount) o;
        return winningAmount == that.winningAmount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningAmount);
    }
}