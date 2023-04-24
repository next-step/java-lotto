package lotto.exception;

import java.util.List;

public class SameNumberException extends IllegalArgumentException {
    private static final String DELIMITER = ", ";
    private static final String MESSAGE = "같은 숫자를 입력했습니다 - 같은 숫자 : ";

    public SameNumberException(List<String> sameNumber) {
        super(MESSAGE + String.join(DELIMITER, sameNumber));
    }
}
