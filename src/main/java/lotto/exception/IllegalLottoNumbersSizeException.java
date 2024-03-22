package lotto.exception;

import java.text.MessageFormat;

public class IllegalLottoNumbersSizeException extends IllegalArgumentException {
    public IllegalLottoNumbersSizeException(int validSize, int size) {
        super(MessageFormat.format("유효하지 않은 로또 번호 개수 입니다. (유효한 번호 개수: {0}, 입력된 번호 개수: {1})", validSize, size));
    }
}
