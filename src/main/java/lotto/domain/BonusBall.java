package lotto.domain;

import lotto.domain.exception.DuplicateLottoNumberException;
import lotto.util.NullCheckUtil;

public class BonusBall extends LottoNumber {

    public BonusBall(final String value, final Lotto lotto) {
        super(value);
        NullCheckUtil.validate(lotto);
        validateDuplicate(lotto);
    }

    private void validateDuplicate(final Lotto lotto) {
        if (lotto.contains(this)) {
            throw DuplicateLottoNumberException.getInstance();
        }
    }
}
