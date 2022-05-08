package lotto.exception;

import lotto.domain.LottoMarkingNumbers;

public class InvalidMatchCount extends IllegalArgumentException {

    private static final String MESSAGE = "matchCount 는 %d개를 초과할 수 없습니다.";

    public InvalidMatchCount() {
        super(String.format(MESSAGE, LottoMarkingNumbers.LOTTO_NUMBER_COUNT));
    }
}
