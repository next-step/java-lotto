package lotto;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static final int MINIMUM_MATCH_COUNT = 0;
    private static final int MAXIMUM_MATCH_COUNT = 6;
    private Map<Integer,Integer> result = new HashMap<>();

    public LottoResult(){
       for(int i = MINIMUM_MATCH_COUNT; i<=MAXIMUM_MATCH_COUNT; i++){
           result.put(i,0);
       }
    }

    public int getTotalSum(){
        int totalSum = 0;
        totalSum += this.result.get(MappingCode.THREE.getCount()) * MappingCode.THREE.getPrizes()
                + this.result.get(MappingCode.FOUR.getCount()) * MappingCode.FOUR.getPrizes()
                + this.result.get(MappingCode.FIVE.getCount()) * MappingCode.FIVE.getPrizes()
                + this.result.get(MappingCode.SIX.getCount()) * MappingCode.SIX.getPrizes();

        return totalSum;
    }

    public void addCountToResult(int count){
        this.result.put(count, result.get(count)+1);
    }

    public float calculateRate(int totalSum, int paidCost){
        return totalSum / (float)paidCost;

    }

    //value 구하기
    public int getValue(int key){
        return result.get(key);
    }

}
