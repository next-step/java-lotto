package calculator.exception;

public class InvalidFormulaException extends IllegalArgumentException {

    public InvalidFormulaException() {
        super("계산할 수 없는 잘못된 수식입니다. 수식을 확인해주세요.");
    }

}
