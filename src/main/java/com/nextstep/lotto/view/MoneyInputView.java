package com.nextstep.lotto.view;

import com.nextstep.lotto.domain.Money;
import com.nextstep.lotto.domain.exceptions.InvalidMoneyException;
import com.nextstep.lotto.view.exceptions.NotEnoughMoneyException;

public class MoneyInputView {
    private static final Long MIN_MONEY = 1000L;

    private final Long userMoney;

    public MoneyInputView(final String userMoney) {
        Long parsedUserMoney = parseToLongSafely(userMoney);
        isEnoughMoney(parsedUserMoney);
        this.userMoney = parsedUserMoney;
    }

    public Money parseMoney() {
        return new Money(userMoney);
    }

    private Long parseToLongSafely(final String userMoney) {
        try {
            return Long.parseLong(userMoney);
        } catch (NumberFormatException e) {
            throw new InvalidMoneyException("금액으로 사용할 수 없는 입력값입니다.");
        }
    }

    private void isEnoughMoney(final Long moneyValue) {
        if (moneyValue < MIN_MONEY) {
            throw new NotEnoughMoneyException("최소 1000원 이상만 입력 가능합니다.");
        }
    }
}
