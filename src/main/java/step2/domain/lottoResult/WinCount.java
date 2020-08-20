package step2.domain.lottoResult;

public class WinCount {
    private int numberOfWin;

    public WinCount(int numberOfWin) {
        this.numberOfWin = numberOfWin;
    }

    public void plus() {
        numberOfWin++;
    }

    public int moneyCount(int money) {
        return money * numberOfWin;
    }

    public int getNumberOfWin() {
        return numberOfWin;
    }
}
