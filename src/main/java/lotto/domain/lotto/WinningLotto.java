package lotto.domain.lotto;

import lotto.domain.exception.InvalidBonusLottoNumberException;

public class WinningLotto {
    private final Lotto lotto;
    private final LottoNumber bonusLottoNumber;

    public WinningLotto(Lotto lotto, LottoNumber bonusLottoNumber) {
        this.lotto = lotto;
        this.bonusLottoNumber = bonusLottoNumber;
    }

    public static WinningLotto of(Lotto lotto, LottoNumber bonusLottoNumber) {
        validateBonusNumber(lotto, bonusLottoNumber);
        return new WinningLotto(lotto, bonusLottoNumber);
    }

    private static void validateBonusNumber(Lotto lotto, LottoNumber bonusLottoNumber) {
        if (lotto.hasNumber(bonusLottoNumber)) {
            throw new InvalidBonusLottoNumberException();
        }
    }

    public Lotto getLotto() {
        return lotto;
    }

    public LottoNumber getBonusLottoNumber() {
        return bonusLottoNumber;
    }
}
