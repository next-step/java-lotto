package lotto.domain;

public class ValidationException extends RuntimeException {
    public ValidationException(String e) {
        super(e);
    }

    public ValidationException(Exception e) {
        super(e);
    }
}
