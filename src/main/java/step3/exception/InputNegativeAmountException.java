package step3.exception;

public final class InputNegativeAmountException extends RuntimeException{

    private final String message = "음수값의 돈이 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
