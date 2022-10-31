package lotto.domain;

import lotto.exception.InvalidInputException;

public class LottoNumber {
    private static final String VALIDATE_NUMBER = "번호의 범위는 1 ~ 45 입니다.";
    private static final Integer LOTTO_MIN_NUMBER = 1;
    private static final Integer LOTTO_MAX_NUMBER = 45;

    private final Integer number;

    public LottoNumber(Integer number) {
        this.number = validateNumber(number);
    }

    public Integer getNumber() {
        return number;
    }

    private Integer validateNumber(Integer number) {
        if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
            throw new InvalidInputException(VALIDATE_NUMBER);
        }
        return number;
    }
}
