package lotto;

public class WinningLotto {
    private LottoManual winLotto;
    private LottoNumber bounsNumber;

    public WinningLotto(LottoManual winLotto, LottoNumber bounsNumber) {
        if (winLotto.contains(bounsNumber)){
            throw new IllegalArgumentException();
        }
        this.winLotto = winLotto;
        this.bounsNumber = bounsNumber;
    }

    public LottoManual getWinLotto() {
        return winLotto;
    }

    public LottoNumber getBounsNumber() {
        return bounsNumber;
    }
}
