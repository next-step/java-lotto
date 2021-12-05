package lotto.domain;

public class WinLotto {
    private final Lotto lotto;
    private final LottoNumber bonusNumber;

    public WinLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateWinLotto(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateWinLotto(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.containLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 종복될 수 없습니다.");
        }
    }
}
