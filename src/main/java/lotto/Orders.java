package lotto;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<Lotto> orders;

    public Orders(int total) {
        this.orders = makeOrders(total);
    }

    public List<Lotto> getLOrders() {
        return this.orders;
    }

    private List<Lotto> makeOrders(int total) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            result.add(new Lotto());
        }
        return result;
    }
}
