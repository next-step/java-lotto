package lotto.exception;

import java.text.MessageFormat;

import static lotto.domain.LottoInformation.*;

public class IllegalLottoNumberException extends IllegalArgumentException {

    public IllegalLottoNumberException(int number) {
        super(MessageFormat.format("유효하지 않은 로또 번호입니다. (로또 번호 범위: {0} ~ {1}, 입력된 번호: {2})", NUMBER_RANGE_FROM, NUMBER_RANGE_TO, number));
    }

}
