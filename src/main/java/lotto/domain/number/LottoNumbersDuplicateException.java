package lotto.domain.number;

public class LottoNumbersDuplicateException extends RuntimeException {
    public static final String MESSAGE = "로또 번호는 6자리는 중복을 허용하지 않습니다.";

    public LottoNumbersDuplicateException() {
        super(MESSAGE);
    }
}
