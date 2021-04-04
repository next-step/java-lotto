package step3.domain.lotto;

public final class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNumber bonusLotto;


    private WinningLotto(Lotto winningLotto, LottoNumber bonusLotto) {
        this.winningLotto = winningLotto;
        this.bonusLotto = bonusLotto;
    }

    public static final WinningLotto from(Lotto lotto, LottoNumber bonusLottoNumber) {
        return new WinningLotto(lotto, bonusLottoNumber);
    }
}
