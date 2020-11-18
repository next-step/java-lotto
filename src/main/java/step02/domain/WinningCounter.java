package step02.domain;

import java.util.Objects;

public class WinningCounter {
    private final int number;
    private final int count;

    private WinningCounter(int number, int count) {
        this.number = number;
        this.count = count;
    }

    public static WinningCounter of(int number, int count) {
        return new WinningCounter(number, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningCounter that = (WinningCounter) o;
        return number == that.number &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, count);
    }

    public boolean isSame(int winningNumber) {
        return number == winningNumber;
    }
}
