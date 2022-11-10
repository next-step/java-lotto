package lotto.exception;

public class DuplicateLottoNumberException extends RuntimeException {

    public DuplicateLottoNumberException() {
        super("지난 주 당첨 번호와 보너스 볼 번호가 중복됩니다.");
    }
}
