package step3.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNum bonusNum;

    public WinningLotto(Lotto winningLotto, LottoNum bonusNum) {
        this.winningLotto = winningLotto;
        this.bonusNum = bonusNum;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNum getBonusNum() {
        return bonusNum;
    }
}
