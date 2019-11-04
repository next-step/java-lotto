package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Insights {

    ZERO(0, 0),
    THREE(5_000, 0),
    FOUR(50_000, 0),
    FIVE(1_500_000, 0),
    SIX(2_000_000_000, 0);

    private static final int NUMBER_ZERO = 0;
    public static Map<Integer, Insights> insights;
    private static int sum;
    private int price;
    private int count;


    static {
        insights = new HashMap<>();
        insights.put(0, ZERO);
        insights.put(1, ZERO);
        insights.put(2, ZERO);
        insights.put(3, THREE);
        insights.put(4, FOUR);
        insights.put(5, FIVE);
        insights.put(6, SIX);
        sum = NUMBER_ZERO;
    }

    Insights(int price, int count) {
        this.price = price;
        this.count = count;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount() {
        this.count++;
    }

    public static int getTotalPrice() {
        for (Map.Entry<Integer, Insights> entry : insights.entrySet()) {
            getPrice(entry);
        }
        return sum;
    }

    private static void getPrice(Map.Entry<Integer, Insights> entry) {
        if (entry.getValue().getCount() > NUMBER_ZERO) {
            sumPrice(entry);
        }
    }

    private static void sumPrice(Map.Entry<Integer, Insights> entry) {
        int count = entry.getValue().getCount();
        for (int i = 0; i < count; i++) {
            sum += entry.getValue().getPrice();
        }
    }
}
