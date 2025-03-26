package lotto.domain;

import lotto.domain.product.Product;

public class UserPaid {

    private final Money money;

    public UserPaid(String money) {
        this.money = new Money(money);
    }

    public Integer getUserCountBy(Product product) {
        return product.divideBy(money);
    }

    public Double getRateBy(Money totalPrize) {
        return totalPrize.rate(this.money);
    }

}
