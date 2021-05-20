package lotto.domain;

public class WinningLotto {

    private final Lotto lotto;
    private final LottoNumber bonumsNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        validateDuplicate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonumsNumber = bonusNumber;
    }

    private void validateDuplicate(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.isContains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 로또번호와 중복될 수 없습니다.");
        }
    }
}
