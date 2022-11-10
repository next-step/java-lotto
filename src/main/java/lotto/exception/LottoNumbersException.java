package lotto.exception;

public class LottoNumbersException extends RuntimeException {
    public LottoNumbersException() {
        super("숫자 6개를 입력해주세요(','로 구분. 중복불가)");
    }
}
