package lotto.domain;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningLotto(List<Integer> lotto, int bonusNumber) {
        this(new Lotto(lotto), new LottoNumber(bonusNumber));
    }

    public WinningLotto(Lotto lotto, LottoNumber bonusNumber) {
        checkValidation(lotto, bonusNumber);
        this.winningLotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void checkValidation(Lotto lotto, LottoNumber bonusNumber) {
        if (lotto.containBonusNumber(bonusNumber)) {
            throw new IllegalArgumentException("보너스 번호는 기존 lotto 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public long match(Lotto lotto) {
        return this.winningLotto.getNumbers().stream().filter(lotto.getNumbers()::contains).count();
    }

    public boolean matchBonusNumber(Lotto lotto) {
        return lotto.containBonusNumber(bonusNumber);
    }
}
