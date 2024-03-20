package lotto.exception;

import lotto.common.ConstantSet;

import static java.lang.String.format;
import static lotto.common.ConstantSet.MIN_LOTTO_NUMBER;

public class LottoNumberOutOfRangeException extends IllegalArgumentException{
    public LottoNumberOutOfRangeException() {
        super(format("로또 번호는 %d와(과) %d 사이의 숫자만 가능합니다.", MIN_LOTTO_NUMBER, ConstantSet.MAX_LOTTO_NUMBER));
    }
}
