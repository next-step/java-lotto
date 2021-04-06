package step4.exception;

public final class InputNegativeAmountException extends RuntimeException{

    private final String message = "음수값이 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
