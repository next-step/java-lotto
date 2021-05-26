package lotto.model;

import lotto.model.config.LottoConfig;
import lotto.view.ViewOutput;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class LottoResultMap {
    private Map<Integer, Integer> lottoResultMap;
    private int expense;

    public LottoResultMap(int expense){
        this.lottoResultMap = new HashMap<Integer, Integer>(){{
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};
        this.expense = expense;
    }

    public void plusByNumKeyMatched(int key) {
        lottoResultMap.put(key, lottoResultMap.get(key) + 1);
    }

    public void printResult() {
        int totalProfit = 0;
        for( Map.Entry<Integer, Integer> lottoResult : lottoResultMap.entrySet() ){
            int numMatched = lottoResult.getKey();
            int numMatchedLottoNumbers = lottoResult.getValue();
            totalProfit += calculateEachReward(numMatched, numMatchedLottoNumbers);
        }
        ViewOutput.printlnProfitRate(calculateProfitRate(totalProfit));
    }

    public BigDecimal calculateProfitRate(int totalProfit){
        if(totalProfit == 0 || expense == 0){

            return new BigDecimal(0);
        }
        return new BigDecimal(totalProfit).divide(new BigDecimal(expense), 4, BigDecimal.ROUND_CEILING);
    }

    private int calculateEachReward(int key, int value){
        ViewOutput.printlnResult(key, value);
        if(LottoConfig.winningRewards.get(key) == 0 || value == 0){
            return 0;
        }
        return LottoConfig.winningRewards.get(key) * value;
    }
}
