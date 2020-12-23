package lotto.domain;

public class WinningLotto {
    private final Lotto winLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(Lotto winLotto, LottoNumber bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public int matchNumberCnt(Lotto lotto) {
        return winLotto.matchNumberCnt(lotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.hasNumber(bonusNumber);
    }
}
