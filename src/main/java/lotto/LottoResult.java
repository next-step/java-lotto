package lotto;

import java.util.Arrays;

public class LottoResult {
    private int[] result;

    public LottoResult(int[] matchCount){
        this.result = Arrays.copyOf(matchCount,matchCount.length);

    }

    public int getTotalSum(){
        int totalSum = 0;
        totalSum += this.result[3]*5000 + this.result[4]*50000
                    +this.result[5]*1500000 + this.result[6]*2000000000;
        return totalSum;
    }

    public float calculateRate(int totalSum, int paidCost){
        return totalSum / (float)paidCost;

    }

}
