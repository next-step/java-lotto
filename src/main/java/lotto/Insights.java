package lotto;

import java.util.HashMap;
import java.util.Map;

public enum Insights {

    THREE(5000),
    FOUR(50000),
    FIVE(1500000),
    SIX(2000000000);

    private static final int ZERO = 0;
    public static Map<Integer, Insights> insights;
    private static int sum;
    private int price;
    private int count;


    static {
        insights = new HashMap<>();
        insights.put(3, THREE);
        insights.put(4, FOUR);
        insights.put(5, FIVE);
        insights.put(6, SIX);
        sum = ZERO;
    }

    Insights(int price) {
        this.price = price;
        this.count = ZERO;
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
        if (entry.getValue().getCount() > ZERO) {
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
