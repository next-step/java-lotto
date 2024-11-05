package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    public static final int PRICE = 1000;

    private final List<LottoNumbers> orders;

    public Orders(int total) {
        this(makeOrders(total));
    }

    public Orders(Money money) {
        this(makeOrders(howManyPurchase(money)));
    }

    public Orders(List<LottoNumbers> orders) {
        this.orders = orders;
    }

    public int getTotalOrders() {
        return this.orders.size();
    }

    public List<LottoNumbers> getOrders() {
        return this.orders;
    }

    private static int howManyPurchase(Money money) {
        return money.get() / PRICE;
    }

    private static List<LottoNumbers> makeOrders(int total) {
        List<LottoNumbers> result = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            result.add(new LottoNumbers());
        }
        return result;
    }
}
