package study.lotto.step2.domain;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(WinningLotto winningLotto, LottoNumber bonusNumber) {
        validateBonusLottoNumber(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public boolean matchBonus(Lotto lotto) {
        return lotto.getLottoNumbers().getLottoNumbers().contains(bonusNumber);
    }

    private void validateBonusLottoNumber(WinningLotto winningLotto, LottoNumber bonusNumber) {
        if(winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호가 당첨 번호에 포함되어 있으면 안됩니다: " + bonusNumber);
        }
    }
}
