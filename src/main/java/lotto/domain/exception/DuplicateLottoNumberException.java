package lotto.domain.exception;

public class DuplicateLottoNumberException extends LottoDomainException {

    private static final DuplicateLottoNumberException DUPLICATE_LOTTO_NUMBER_EXCEPTION =
            new DuplicateLottoNumberException("중복된 로또 번호가 있습니다.");

    private DuplicateLottoNumberException(String message) {
        super(message);
    }

    public static DuplicateLottoNumberException getInstance() {
        return DUPLICATE_LOTTO_NUMBER_EXCEPTION;
    }
}
