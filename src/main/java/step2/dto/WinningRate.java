package step2.dto;

import java.util.Objects;

public class WinningRate {
    private static final int BASE_ONE = 1;

    private final float winningRate;

    public WinningRate(float winningRate) {
        this.winningRate = winningRate;
    }

    public float getWinningRate() {
        return winningRate;
    }

    public boolean lessThanBaseRate() {
        return winningRate < BASE_ONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WinningRate that = (WinningRate) o;
        return Float.compare(that.winningRate, winningRate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningRate);
    }
}
