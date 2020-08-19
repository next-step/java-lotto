package step1.exception;

public class UserCustomException extends RuntimeException {
    public UserCustomException(String message) {
        super(message);
    }
}
