package lotto.exception;

public class LottoNumberException extends RuntimeException {
    public LottoNumberException() {
        super("1 ~ 45 사이의 숫자를 입력해주세요.");
    }
}
