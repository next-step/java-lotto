package lotto.view;

import lotto.domain.LottoNumber;

public final class LottoNumberValidator extends NumberValidator {

    static final String OUT_BOUND_MESSAGE = "숫자는 1 ~ 45 사이의 값을 가져야 합니다!";

    @Override
    protected void validate(String input) {
        super.validate(input);
        checkBound(input);
    }

    private void checkBound(String input) {
        int number = Integer.parseInt(input);

        if (number < LottoNumber.LOWER_BOUND || number > LottoNumber.UPPER_BOUND) {
            throw new IllegalArgumentException(OUT_BOUND_MESSAGE);
        }
    }
}
