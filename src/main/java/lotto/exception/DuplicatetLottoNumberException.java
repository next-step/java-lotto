package lotto.exception;

public class DuplicatetLottoNumberException extends IllegalStateException {

    private static final String MESSGE = "당첨 번호는 중복될 수 없습니다.";

    public DuplicatetLottoNumberException() {
        super(MESSGE);
    }
}
