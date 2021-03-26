package step3.domain;

import java.util.Map;

public class Calculator {

    private Map<Rank, Integer> earnMap;

    public Calculator(Map<Rank, Integer> earnMap) {
        this.earnMap = earnMap;
    }
    public double total() {
        double sum = 0;
        for (Rank rank : earnMap.keySet()) {
            sum += rank.getCountOfMatch() * rank.getCountOfMatch();
        }

        return sum;
    }

    public double benefit(Price totalPrice) {
        return total() / totalPrice.getPrice();
    }
}
