package lotto.exception;

import java.text.MessageFormat;

public class IllegalLottoNumberException extends IllegalArgumentException {

    public IllegalLottoNumberException(int rangeFrom, int rangeTo, int number) {
        super(MessageFormat.format("유효하지 않은 로또 번호입니다. (로또 번호 범위: {0} ~ {1}, 입력된 번호: {2})", rangeFrom, rangeTo, number));
    }

}
