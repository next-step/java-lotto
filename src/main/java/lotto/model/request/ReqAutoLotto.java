package lotto.model.request;

import lotto.domain.Money;

public class ReqAutoLotto implements ReqLotto {
    private final Money money;

    public ReqAutoLotto(Money money) {
        this.money = money;
    }

    public Money getMoney() {
        return money;
    }
}
