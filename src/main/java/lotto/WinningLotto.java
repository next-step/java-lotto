package lotto;

public class WinningLotto {
    private Lotto winLotto;
    private int bounsNumber;

    public WinningLotto(Lotto winLotto, int bounsNumber) {
        this.winLotto = winLotto;
        this.bounsNumber = bounsNumber;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public int getBounsNumber() {
        return bounsNumber;
    }
}
