package calculator;

public class DivideByZeroException extends RuntimeException {

    public DivideByZeroException() {
        super("0으로 나눌 수는 없습니다.");
    }

}
