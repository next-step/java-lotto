package lotto.objects;

public class Player {
    private static final int PRICE_PER_LOTTO = 1000;

    private final Money money;

    public Player(Money money) {
        this.money = money;
    }

    public int buy() {
        return money.getMoney() / PRICE_PER_LOTTO;
    }
}
