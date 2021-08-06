package calculators.exceptions;

public class NegativeNumberException extends RuntimeException {

    public NegativeNumberException() {
        super("음수는 사용할 수 없습니다.");
    }
}
