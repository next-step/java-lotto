package step4.exception;

public final class InputInvalidStringLottoException extends RuntimeException{

    private final String message = "잘못된 형식의 문자열이 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
