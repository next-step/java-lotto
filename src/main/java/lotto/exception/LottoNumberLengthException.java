package lotto.exception;

public class LottoNumberLengthException extends RuntimeException {
    public static final String LengthException = "로또 번호를 잘못 입력 했습니다.";

    public LottoNumberLengthException() {
        super(LengthException);
    }
}
