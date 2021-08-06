package calculators.exceptions;

public class NonNumericException extends RuntimeException {

    public NonNumericException() {
        super("숫자만 사용 가능합니다.");
    }
}
