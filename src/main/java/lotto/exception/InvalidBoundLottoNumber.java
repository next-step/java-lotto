package lotto.exception;

import lotto.domain.LottoNumber;

public class InvalidBoundLottoNumber extends IndexOutOfBoundsException {

    private static final String MESSAGE = "로또 숫자는 %d ~ %d 사이의 값만 가능합니다.";

    public InvalidBoundLottoNumber() {
        super(String.format(MESSAGE, LottoNumber.MIN_NUMBER, LottoNumber.MAX_NUMBER));
    }
}
