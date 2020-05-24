package calculator.domain.calculator;

public class NonNumericValuesException extends RuntimeException {
    public NonNumericValuesException() {
        super("숫자 이외의 값은 지원하지 않습니다.");
    }
}
