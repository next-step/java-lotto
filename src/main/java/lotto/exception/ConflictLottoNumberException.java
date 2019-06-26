package lotto.exception;

public class ConflictLottoNumberException extends IllegalStateException {

    private static final String MESSGE = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    public ConflictLottoNumberException() {
        super(MESSGE);
    }
}
