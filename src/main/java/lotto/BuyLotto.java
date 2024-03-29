package lotto;

import java.util.List;

public abstract class BuyLotto {
    private Money money;
    private int count;
    private List<LottoNumberStrategy> strategies;

    public BuyLotto(Money money, int count, List<LottoNumberStrategy> strategies) {
        this.money = money;
        this.count = count;
        this.strategies = strategies;
    }

    public List<LottoNumberStrategy> getStrategies() {
        return strategies;
    }

    public Money getMoney() {
        return money;
    }

    public int getCount() {
        return count;
    }
}
