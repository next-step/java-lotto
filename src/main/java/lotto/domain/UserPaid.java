package lotto.domain;

public class UserPaid {

    private final Money money;

    public UserPaid(Money money) {
        this.money = money;
    }

    public Integer getUserCountBy(Product product) {
        return product.divideBy(money);
    }

}
