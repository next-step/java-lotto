package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.lotto.domain.exception.LottoAmountCannotBeZeroOrNegativeException;
import com.nextstep.camp.lotto.domain.exception.LottoAmountNotDivisibleByLottoPriceException;

public class LottoAmount {

    private final int value;

    public static final int LOTTO_PRICE = 1000;
    private static final int MIN_VALUE = 0;
    private LottoAmount(int value) {
        validate(value);
        this.value = value;
    }

    private static void validate(int value) {
        if (value <= MIN_VALUE) {
            throw new LottoAmountCannotBeZeroOrNegativeException();
        }
        if (isNotDivisibleByLottoPrice(value)) {
            throw new LottoAmountNotDivisibleByLottoPriceException();
        }
    }

    private static boolean isNotDivisibleByLottoPrice(int value) {
        return value % LOTTO_PRICE != 0;
    }

    public static LottoAmount of(int value) {
        return new LottoAmount(value);
    }

    public int getValue() {
        return value;
    }

    public LottoCount getLottoCount() {
        return LottoCount.of(value / LOTTO_PRICE);
    }
}
