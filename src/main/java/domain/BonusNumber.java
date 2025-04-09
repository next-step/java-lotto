package domain;

import java.util.List;

public class BonusNumber {
    private final LottoNumber bonusNumber;

    public BonusNumber(int bonusNumber) {
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    public BonusNumber(int bonusNumber, Lotto winningLotto) {
        this(bonusNumber);

        if (winningLotto.contains(this.bonusNumber)) {
            throw new IllegalArgumentException("당첨 번호에 보너스 넘버가 포함되어있습니다. number : " + bonusNumber);
        }
    }

    public LottoNumber getLottoNumber() {
        return bonusNumber;
    }
}
