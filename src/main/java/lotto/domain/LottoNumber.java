package lotto.domain;

import lotto.exception.InvalidInputException;

import static lotto.util.NumberUtil.defaultNumberList;

public class LottoNumber {
    private static final String VALIDATE_NUMBER = "로또 번호의 범위는 1 ~ 45 입니다.";

    private final Integer number;

    public LottoNumber(Integer number) {
        this.number = validateNumber(number);
    }

    public Integer getNumber() {
        return number;
    }

    private Integer validateNumber(Integer number) {
        if (!defaultNumberList().contains(number)) {
            throw new InvalidInputException(VALIDATE_NUMBER);
        }
        return number;
    }
}
