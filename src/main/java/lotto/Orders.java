package lotto;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private final List<Lotto> orders;

    public Orders(int total) {
        this.orders = makeOrders(total);
    }

    public Orders(List<Lotto> orders) {
        this.orders = orders;
    }

    public List<Lotto> getOrders() {
        return this.orders;
    }

    private List<Lotto> makeOrders(int total) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < total; i++) {
            result.add(new Lotto());
        }
        return result;
    }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Lotto lotto : orders) {
            builder.append(lotto);
            builder.append("\n");
        }
        return builder.toString();
    }
}
