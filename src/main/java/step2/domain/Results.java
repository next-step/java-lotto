package step2.domain;

import java.util.HashMap;
import java.util.Map;

public class Results {

    private final Map<Integer, Integer> store = new HashMap<>();

    private static final int FOURTH_WINNING_AMOUNT = 5000;
    private static final int THIRD_WINNING_AMOUNT = 50_000;
    private static final int SECOND_WINNING_AMOUNT = 1_500_000;
    private static final int FIRST_WINNING_AMOUNT = 2_000_000_000;


    public Results() {
        this.store.put(3, 0);
        this.store.put(4, 0);
        this.store.put(5, 0);
        this.store.put(6, 0);
    }

    public Map<Integer, Integer> get() {
        return this.store;
    }

    public int sum() {
        return this.store.get(3) * FOURTH_WINNING_AMOUNT +
            this.store.get(4) * THIRD_WINNING_AMOUNT +
            this.store.get(5) * SECOND_WINNING_AMOUNT +
            this.store.get(6) * FIRST_WINNING_AMOUNT;
    }

    public void add(int matchedCount) {
        Integer count = this.store.get(matchedCount);
        store.put(matchedCount, ++count);
    }
}
