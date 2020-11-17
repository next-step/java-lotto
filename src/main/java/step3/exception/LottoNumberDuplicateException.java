package step3.exception;

public class LottoNumberDuplicateException extends IllegalArgumentException {

    public static final String LOTTO_NUMBER_DUPLICATE = "로또번호는 중복될수 없습니다.";

    public LottoNumberDuplicateException() {
        super(LOTTO_NUMBER_DUPLICATE);
    }
}
