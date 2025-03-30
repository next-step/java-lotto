package step4.lotto.model;

import step4.lotto.exception.LottoMatchCountInvalidFormatException;
import step4.lotto.exception.LottoMatchCountInvalidValueException;

public class LottoMatchCount extends Count {

    public LottoMatchCount(long value) {
        super(value);
        validateLottoMatchCount(value);
    }

    private void validateLottoMatchCount(String value) {
        try {
            Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new LottoMatchCountInvalidFormatException();
        }
        validateLottoMatchCount(Long.parseLong(value));
    }

    private void validateLottoMatchCount(long value) {
        if (value < 0 || value > 6) {
            throw new LottoMatchCountInvalidValueException();
        }
    }

}
