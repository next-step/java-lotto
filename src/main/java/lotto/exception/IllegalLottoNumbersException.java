package lotto.exception;

import java.text.MessageFormat;
import java.util.List;

public class IllegalLottoNumbersException extends IllegalArgumentException {
    public IllegalLottoNumbersException(List<Integer> numbers) {
        super(MessageFormat.format("유효하지 않은 로또 번호입니다. (로또 번호: {0}, 번호 개수: {1})", numbers, numbers.size()));
    }
}
