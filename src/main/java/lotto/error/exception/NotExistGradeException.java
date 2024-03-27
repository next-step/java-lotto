package lotto.error.exception;

import java.text.MessageFormat;

public class NotExistGradeException extends RuntimeException {

    public NotExistGradeException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", "존재하지 않는 순위입니다.",
            parameter));
    }
}
