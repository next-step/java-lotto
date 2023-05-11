package lotto.domain.result;

import java.util.Objects;

public class WinCount {

    private int numberOfWin;

    public WinCount(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    public void plusOne() {
        numberOfWin++;
    }

    public int getNumberOfWin() {
        return numberOfWin;
    }

    @Override
    public String toString() {
        return "WinCount{" +
                "numberOfWin=" + numberOfWin +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinCount winCount = (WinCount) o;
        return numberOfWin == winCount.numberOfWin;
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfWin);
    }
}
