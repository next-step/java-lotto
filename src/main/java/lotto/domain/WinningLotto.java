package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNo bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = new LottoNo(bonusNumber);
    }

    public Lotto lotto() {
        return lotto;
    }

    public LottoNo bonusNumber() {
        return bonusNumber;
    }
}
