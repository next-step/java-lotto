package calculator;

public class NegativeIntegerElementException extends RuntimeException {

    private static final String MESSAGE = "양의 정수만 사용할 수 있습니다.";

    public NegativeIntegerElementException() {
        super(MESSAGE);
    }

}
