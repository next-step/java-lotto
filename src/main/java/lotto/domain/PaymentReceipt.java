package lotto.domain;

import lotto.domain.product.Product;

public class PaymentReceipt {

    private final Money money;

    public PaymentReceipt(String money) {
        this.money = new Money(money);
    }

    public Integer getUserCountBy(Product product) {
        return product.divideBy(money);
    }

    public Double getRateBy(Money totalPrize) {
        return totalPrize.rate(this.money);
    }

}
