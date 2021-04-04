package step3.domain.lotto;

import step3.exception.LottoNumberNullPointerException;

import java.util.Objects;

public final class BonusLottoNumber {

    private LottoNumber bonusLottoNumber;

    private BonusLottoNumber(LottoNumber bonusLottoNumber) {
        validateObjectIsNull(bonusLottoNumber);
        this.bonusLottoNumber = bonusLottoNumber;
    }

    private final void validateObjectIsNull(LottoNumber bonusLottoNumber) {
        if (Objects.isNull(bonusLottoNumber)) {
            throw new LottoNumberNullPointerException();
        }
    }

    public static final BonusLottoNumber valueOf(int bonusNumber) {
        return valueOf(LottoNumber.valueOf(bonusNumber));
    }

    public static final BonusLottoNumber valueOf(LottoNumber bonusNumber) {
        return new BonusLottoNumber(bonusNumber);
    }


    public final boolean isIncludeByLotto(Lotto lotto) {
        return lotto.isIncludeLottoNumber(bonusLottoNumber);
    }
}
