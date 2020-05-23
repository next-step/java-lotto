package calculator.domain.calculator;

public class NegativeInputException extends RuntimeException {
    public NegativeInputException() {
        super("음수 값은 지원하지 않습니다.");
    }
}
