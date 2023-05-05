package lotto.exception;

public class LottoNumberOutOfRangeException extends RuntimeException {
    public LottoNumberOutOfRangeException()  {
        super("LottoNumber 숫자는 1~45 사이만 허용된다");
    }
}
