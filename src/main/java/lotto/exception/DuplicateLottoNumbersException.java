package lotto.exception;

import java.text.MessageFormat;
import java.util.List;

public class DuplicateLottoNumbersException extends IllegalArgumentException {
    public DuplicateLottoNumbersException(List<Integer> numbers) {
        super(MessageFormat.format("중복된 로또 번호를 입력했습니다. (입력한 로또 번호: {0}", numbers));
    }
}
