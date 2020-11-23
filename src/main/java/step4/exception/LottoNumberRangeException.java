package step4.exception;

public class LottoNumberRangeException extends IllegalArgumentException {

    public static final String LOTTO_NUMBER_RANGE_EXCEPTION = "로또 번호들은 제한된 범위에서 넘을수 없습니다.";

    public LottoNumberRangeException() {
        super(LOTTO_NUMBER_RANGE_EXCEPTION);
    }
}
