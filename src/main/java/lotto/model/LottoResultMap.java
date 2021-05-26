package lotto.model;

import lotto.model.config.LottoConfig;
import lotto.view.ViewOutput;

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
        ViewOutput.printlnProfitRate(calculateProfitRate(expense, totalProfit));
    }

    private int calculateProfitRate(int expense, int totalProfit){
        if(totalProfit == 0 || expense == 0){
            return 0;
        }
        return (totalProfit / expense);
    }

    private int calculateEachReward(int key, int value){
        ViewOutput.printlnResult(key, value);
        if(LottoConfig.winningRewards.get(key) == 0 || value == 0){
            return 0;
        }
        return LottoConfig.winningRewards.get(key) * value;
    }
}
