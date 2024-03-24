package lotto.domain;

import lotto.constant.Constant;

import java.util.Objects;
import java.util.Random;

public class LottoNumber {
    private final Number number;

    public LottoNumber(int number) {
        this(new Number(number));
    }

    public LottoNumber(Number number) {
        this.number = number;
    }

    public Number getLottoNumber() {
        return this.number;
    }

}
