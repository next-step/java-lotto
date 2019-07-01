package lotto.model;

public class Wallet {

    private Money money;

    public Wallet(Money money) {
        this.money = money;
    }

    void spendOnLotto(long numberOfLotto) {
        money = money.spendOnLotto(numberOfLotto);
    }

    public long countAvailableByLotto() {
        return money.divide(Lotto.PRICE);
    }
}
