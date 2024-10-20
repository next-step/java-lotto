package lotto.model;

import lotto.model.dto.LottoNumber;

public class Winning {
    public static final String INVALID_BONUS_NUMBER = "당첨번호중에 보너스번호가 이미 존재합니다.";
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public Winning(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(INVALID_BONUS_NUMBER);
        }
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public LottoNumber bonusNumber() {
        return bonusNumber;
    }

    public Lotto winningLotto() {
        return winningLotto;
    }
}
