package lotto.view;

import lotto.domain.Money;
import lotto.domain.exceptions.InvalidMoneyException;

public class MoneyInputView {
    private final Long userMoney;

    public MoneyInputView(final String userMoney) {
        Long parsedUserMoney = parseToLongSafely(userMoney);
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
}
