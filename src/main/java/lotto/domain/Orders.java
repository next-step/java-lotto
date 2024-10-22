package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    public static final int PRICE = 1000;

    private final List<Lotto> orders;

    public Orders(int total) {
        this.orders = makeOrders(total);
    }

    public Orders(Money money) {
        this.orders = makeOrders(howManyPurchase(money));
    }

    public Orders(List<Lotto> orders) {
        this.orders = orders;
    }

    public int getTotalOrders() {
        return this.orders.size();
    }

    public List<Lotto> getOrders() {
        return this.orders;
    }

    private int howManyPurchase(Money money) {
        return money.get() / PRICE;
    }

    private List<Lotto> makeOrders(int total) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            result.add(new Lotto());
        }
        return result;
    }
}
