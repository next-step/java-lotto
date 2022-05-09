package lotto.exception;

import lotto.domain.LottoNumbers;

public class InvalidLottoNumberCount extends IllegalArgumentException {

    private static final String MESSAGE = "로또번호는 %d개를 가져야합니다.";

    public InvalidLottoNumberCount() {
        super(String.format(MESSAGE, LottoNumbers.LOTTO_NUMBER_COUNT));
    }
}
