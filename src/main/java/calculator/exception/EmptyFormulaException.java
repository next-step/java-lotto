package calculator.exception;

public class EmptyFormulaException extends IllegalArgumentException {

    public EmptyFormulaException() {
        super("수식은 빈 문자열일 수 없습니다.");
    }

}
