package step3.lotto.model;

import step3.lotto.exception.LottoMatchCountException;

public class LottoMatchCount extends Count {

    public LottoMatchCount(long value) {
        super(value);
        validateLottoMatchCount(value);
    }

    private void validateLottoMatchCount(String value) {
        try {
            Long.parseLong(value);
        } catch (NumberFormatException e) {
            throw new LottoMatchCountException();
        }
        validateLottoMatchCount(Long.parseLong(value));
    }

    private void validateLottoMatchCount(long value) {
        if (value < 0 || value > 6) {
            throw new LottoMatchCountException();
        }
    }

}
