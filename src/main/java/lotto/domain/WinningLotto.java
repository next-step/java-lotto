package lotto.domain;

public class WinningLotto {

    private final Lotto winningLotto;
    private final LottoNo lottoNo;

    public WinningLotto(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("invalid bonus number: " + bonusNumber);
        }
        this.winningLotto = winningLotto;
        this.lottoNo = LottoNo.of(bonusNumber);
    }

    public int matchCount(Lotto lotto) {
        return winningLotto.matchCount(lotto);
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.contains(lottoNo.getNumber());
    }
}
