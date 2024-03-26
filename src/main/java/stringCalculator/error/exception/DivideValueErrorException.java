package stringCalculator.error.exception;

import java.text.MessageFormat;

public class DivideValueErrorException extends RuntimeException {

    public DivideValueErrorException(Object leftOperand, Object rightOperand) {
        super(MessageFormat.format("{0}, 좌항: {1}, 우항: {2}", "나눗셈의 결과는 정수여야 합니다", leftOperand,
            rightOperand));
    }
}
