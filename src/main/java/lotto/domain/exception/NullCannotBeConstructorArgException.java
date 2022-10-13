package lotto.domain.exception;

public class NullCannotBeConstructorArgException extends RuntimeException {

    private static final NullCannotBeConstructorArgException NOT_NUMBER_STRING_EXCEPTION
            = new NullCannotBeConstructorArgException("Null은 생성자의 인자가 될 수 없습니다.");

    private NullCannotBeConstructorArgException(String message) {
        super(message);
    }

    public static NullCannotBeConstructorArgException getInstance() {
        return NOT_NUMBER_STRING_EXCEPTION;
    }
}
