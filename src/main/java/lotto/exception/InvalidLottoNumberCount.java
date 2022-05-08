package lotto.exception;

import lotto.domain.LottoMarkingNumbers;

public class InvalidLottoNumberCount extends IllegalArgumentException {

    private static final String MESSAGE = "로또번호는 %d개를 가져야합니다.";

    public InvalidLottoNumberCount() {
        super(String.format(MESSAGE, LottoMarkingNumbers.LOTTO_NUMBER_COUNT));
    }
}
