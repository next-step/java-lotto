package lotto.domain.result;

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
}
