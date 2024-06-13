package domain;

import java.util.Set;

public class WinningLotto {

    private Lotto lotto;
    private LottoNumber bonusNumber;

    protected WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다");
        }
        return new WinningLotto(lotto, bonusNumber);
    }

    public Set<LottoNumber> getNumbers() {
        return lotto.getNumbers();

    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }

}
