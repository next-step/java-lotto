package lotto.domain.exception;

public class DuplicatedLottoNumberExcetion extends LottoException {
    private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "로또는 중복되지 않는 숫자로 구성됩니다.";

    public DuplicatedLottoNumberExcetion(String... message) {
        super(DUPLICATED_LOTTO_NUMBER_MESSAGE, message);
    }
}
