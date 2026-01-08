package lotto.domain;

public record WinningLotto(Lotto lotto, LottoNumber bonusNumber) {

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this(lotto, LottoNumber.valueOf(bonusNumber));
    }

    public WinningLotto {
        if (lotto.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.contains(bonusNumber);
    }
}