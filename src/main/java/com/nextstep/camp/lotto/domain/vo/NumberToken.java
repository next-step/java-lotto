package com.nextstep.camp.lotto.domain.vo;

import com.nextstep.camp.common.utils.NumberUtils;
import com.nextstep.camp.common.utils.StringUtils;
import com.nextstep.camp.lotto.domain.exception.NotFoundValueException;
import com.nextstep.camp.lotto.domain.exception.NotNumberException;

public class NumberToken implements ExpressionToken {
    private final int value;

    private NumberToken(String value) {
        validate(value);
        this.value = Integer.parseInt(value);
    }

    private static void validate(String value) {
        if (StringUtils.hasNotText(value)) {
            throw new NotFoundValueException();
        }
        if (NumberUtils.isNotNumber(value)) {
            throw new NotNumberException();
        }
    }

    public static NumberToken of(String token) {
        return new NumberToken(token);
    }

    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
