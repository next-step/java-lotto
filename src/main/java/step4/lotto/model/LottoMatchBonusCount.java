package step4.lotto.model;

import step4.lotto.exception.LottoMatchCountException;
import step4.lotto.exception.LottoMatchCountInvalidFormatException;
import step4.lotto.exception.LottoMatchCountInvalidValueException;

public class LottoMatchBonusCount extends Count {

    public LottoMatchBonusCount(long value) {
        super(value);
        validateLottoMatchBonusCount(value);
    }

    private void validateLottoMatchBonusCount(String value) {
        try {
            Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new LottoMatchCountInvalidFormatException();
        }
        validateLottoMatchBonusCount(Long.parseLong(value));
    }

    private void validateLottoMatchBonusCount(long value) {
        if (value < 0 || value > 1) {
            throw new LottoMatchCountInvalidValueException();
        }
    }

}
