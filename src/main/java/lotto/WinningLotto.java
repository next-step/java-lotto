package lotto;

public class WinningLotto {
    private LottoAuto winLotto;
    private LottoNumber bounsNumber;

    public WinningLotto(LottoAuto winLotto, LottoNumber bounsNumber) {
        if (winLotto.contains(bounsNumber)){
            throw new IllegalArgumentException();
        }
        this.winLotto = winLotto;
        this.bounsNumber = bounsNumber;
    }

    public LottoAuto getWinLotto() {
        return winLotto;
    }

    public LottoNumber getBounsNumber() {
        return bounsNumber;
    }
}
