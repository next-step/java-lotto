package lottos.domain.exceptions;

public class LottoNumberRangeIncorrectException extends RuntimeException {

    public LottoNumberRangeIncorrectException() {
        super("로또 숫자의 범위가 올바르지않습니다.");
    }

}
