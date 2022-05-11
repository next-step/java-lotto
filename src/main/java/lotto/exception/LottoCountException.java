package lotto.exception;

public class LottoCountException extends RuntimeException {
    private static final String MESSAGE = "수동 생성된 로또의 갯수 와 다릅니다. (입력 받은 로또의 갯수 :%d)";

    public LottoCountException(int lottoSize) {
        super(String.format(MESSAGE, lottoSize));
    }
}
