package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<Rank, Integer> result = new HashMap<>();

    public LottoResult(){
        for(Rank rank : Rank.values()) {
            this.result.put(rank, 0);
        }
    }
    public int getTotalSum(){
        int totalSum = 0;
        for(Rank rank : this.result.keySet()) {
            totalSum += rank.calculateTotalPrize(result.get(rank));
        }
        return totalSum;
    }

    public void calculateResult(Rank rank)  {
        this.result.put(rank, this.result.get(rank) +1);
    }

    public float calculateRate(int totalSum, int paidCost) {
        return totalSum / (float) paidCost;
    }

    public int get(Rank rank) {
        return this.result.get(rank);
    }
}