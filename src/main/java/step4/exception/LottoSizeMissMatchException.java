package step4.exception;

public final class LottoSizeMissMatchException extends RuntimeException{

    private final String message = "로또 숫자가 맞지 않습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}