package step3.exception;

public final class LottoNumberOutOfRangeException extends RuntimeException{

    private final String message = "로또의 범위를 벗아난 숫자가 입력되었습니다.";

    @Override
    public String getMessage() {
        return message;
    }

}
