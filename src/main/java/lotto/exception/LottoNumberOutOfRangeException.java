package lotto.exception;

import static lotto.domain.model.LottoNumber.BOTTOM_OF_RANGE_INCLUSIVE;
import static lotto.domain.model.LottoNumber.TOP_OF_RANGE_INCLUSIVE;

public class LottoNumberOutOfRangeException extends IllegalArgumentException {

    private static final String OUT_OF_BOUNDS_MESSAGE = String.format("로또 숫자의 범위는 %d ~ %d 입니다.",
            BOTTOM_OF_RANGE_INCLUSIVE, TOP_OF_RANGE_INCLUSIVE);

    public LottoNumberOutOfRangeException() {
        this(OUT_OF_BOUNDS_MESSAGE);
    }

    public LottoNumberOutOfRangeException(String message) {
        super(message);
    }
}
