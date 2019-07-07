package lotto;

public class WinningLotto {
    private Lotto winLotto;
    private LottoNumber bounsNumber;

    public WinningLotto(Lotto winLotto, LottoNumber bounsNumber) {
        if (winLotto.contains(bounsNumber)){
            throw new IllegalArgumentException();
        }
        this.winLotto = winLotto;
        this.bounsNumber = bounsNumber;
    }

    public Lotto getWinLotto() {
        return winLotto;
    }

    public LottoNumber getBounsNumber() {
        return bounsNumber;
    }
}
