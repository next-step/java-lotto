package step2.exception;

public final class InvalidNumberInputException extends RuntimeException {
    private final String message = "범위를 벗어난 값이 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
