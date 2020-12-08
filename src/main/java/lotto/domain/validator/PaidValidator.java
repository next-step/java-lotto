package lotto.domain.validator;

import lotto.LottoMachine;

public final class PaidValidator extends NumberValidator {

    static final String NOT_MULTIPLE_MESSAGE = LottoMachine.PAY + "의 배수가 아닙니다!";

    @Override
    public void validate(final String amount) {
        super.validate(amount);
        checkNumeric(amount);
        checkMultiple(amount);
    }

    private void checkMultiple(final String input) {
        if (Integer.parseInt(input) % LottoMachine.PAY != 0) {
            throw new IllegalArgumentException(NOT_MULTIPLE_MESSAGE);
        }
    }
}
