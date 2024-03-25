package lotto.error.exception;

import java.text.MessageFormat;
import lotto.error.ErrorMessage;

public class NotExistGradeException extends RuntimeException {

    public NotExistGradeException(Object parameter) {
        super(MessageFormat.format("{0} 입력값: {1}", ErrorMessage.NOT_EXIST_GRADE.getMessage(),
            parameter));
    }
}
