package step4;


import java.util.Map;

public class LottoYield {

    private Map<Rank, Integer> earnMap;

    public LottoYield(Map<Rank, Integer> earnMap) {
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
