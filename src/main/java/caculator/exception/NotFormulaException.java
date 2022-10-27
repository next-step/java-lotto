package caculator.exception;

public class NotFormulaException extends RuntimeException {
    public NotFormulaException() {
        super("수식이 맞는지 확인 바랍니다.");
    }
}
