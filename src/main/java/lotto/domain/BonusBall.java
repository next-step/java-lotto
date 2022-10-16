package lotto.domain;

import lotto.domain.exception.DuplicateLottoNumberException;

public class BonusBall extends LottoNumber {

    public BonusBall(final String value, final Lotto lotto) {
        super(value);
        validateDuplicate(lotto);
    }

    private void validateDuplicate(final Lotto lotto) {
        if (lotto.isMatch(this)) {
            throw DuplicateLottoNumberException.getInstance();
        }
    }
}
