package step2.exception;

public final class MissMatchSizeException extends RuntimeException {

    private final String message = "갯수가 맞지 않습니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
