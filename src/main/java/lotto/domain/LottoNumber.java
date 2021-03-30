package lotto.domain;

import lotto.exception.LottoException;

public class LottoNumber {

    private static final int NUMBER_RANGE_MIN = 1;
    private static final int NUMBER_RANGE_MAX = 45;
    private static final String NUMBER_RANGE_OFF_MESSAGE = "1부터 45사이의 숫자를 입력해주세요";
    private int number;

    public LottoNumber(Integer number) {
        if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
            throw new LottoException(NUMBER_RANGE_OFF_MESSAGE);
        }
    }
}
