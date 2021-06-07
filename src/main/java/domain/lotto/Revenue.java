package domain.lotto;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class Revenue {
    private double revenue;

    public double statistics(double price, HashMap<Integer, Integer> result) {
        AtomicReference<Double> revenue_sum = new AtomicReference<>((double) 0);
        result.forEach((integer, integer2) -> {
            revenue_sum.updateAndGet(v -> new Double((double) (v + integer * integer2)));
        });
        revenue = Math.floor(revenue_sum.get() / price * 100) / 100;
        return revenue;
    }
}
