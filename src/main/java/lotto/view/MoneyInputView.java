package lotto.view;

import lotto.domain.Money;
import lotto.domain.exceptions.InvalidMoneyException;

public class MoneyInputView {
    private final String userMoney;

    public MoneyInputView(final String userMoney) {
        this.userMoney = userMoney;
    }

    public Money parseMoney() {
        try {
            long moneyValue = Long.parseLong(userMoney);

            return new Money(moneyValue);
        } catch (NumberFormatException e) {
            throw new InvalidMoneyException("금액으로 사용할 수 없는 입력값입니다.");
        }
    }
}
