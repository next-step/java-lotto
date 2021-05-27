package lotto.exception;

public class WinningLottoNonPositiveNumberException extends RuntimeException {
    public WinningLottoNonPositiveNumberException() {
        super("당첨 번호는 양수만 입력할 수 있습니다.");
    }
}
