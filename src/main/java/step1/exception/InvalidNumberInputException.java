package step1.exception;

public class InvalidNumberInputException extends RuntimeException {
    private final String message = "음수가 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
