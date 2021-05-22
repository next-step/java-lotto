package step2;

public class NegativeNumberException extends RuntimeException{
    private static final String message = "음수 입니다.";

    public NegativeNumberException() {
        super(message);
    }
}
