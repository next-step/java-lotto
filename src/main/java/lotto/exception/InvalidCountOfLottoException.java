package lotto.exception;

public class InvalidCountOfLottoException extends IllegalArgumentException  {

    private static final String MESSGE = "지불한 금액보다 많은 로또를 구입할수 없습니다.";

    public InvalidCountOfLottoException() {
        super(MESSGE);
    }
}
