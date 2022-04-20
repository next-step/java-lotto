package exception;

public class InvalidFormularException extends RuntimeException {
    private static final String MESSAGE = "ERROR] 입력받은 공백: %d, 필요한 공백: %d";

    public InvalidFormularException(String actual, String expected) {
        super(String.format(MESSAGE, actual, expected));
    }
}
