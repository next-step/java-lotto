package step2.exception;

public final class LottoNumberMissMatchSizeException extends RuntimeException {

    private final String message = "로또 숫자 갯수가 맞지 않습니다.";

    @Override
    public String getMessage() {
        return message;
    }
}
