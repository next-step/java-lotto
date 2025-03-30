package step4.lotto.exception;

public class LottoMatchCountInvalidValueException extends LottoMatchCountException {

    public static final String MESSAGE = "로또 번호가 매칭된 카운트는 0 ~ 6 사이의 정수여야 합니다.";

    public LottoMatchCountInvalidValueException() {
        super(MESSAGE);
    }

}
