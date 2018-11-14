package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private Map<MappingCode,Integer> result = new HashMap<>();

    public LottoResult(){
        for(MappingCode code : MappingCode.values()) {
            this.result.put(code, 0);
        }
    }
    public int getTotalSum(){
        int totalSum = 0;
        for(MappingCode code : this.result.keySet()) {
            totalSum +=code.calculateTotalPrize(result.get(code));
        }
        return totalSum;
    }

    public void addCountToResult(int count) {
        for (MappingCode code : MappingCode.values()) {
            if (code.matchCode(count)) {
                this.result.put(code, result.get(code) + 1);
            }
        }
    }

    public float calculateRate(int totalSum, int paidCost) {
        return totalSum / (float) paidCost;
    }

    public int get(MappingCode code) {
        return this.result.get(code);
    }
}