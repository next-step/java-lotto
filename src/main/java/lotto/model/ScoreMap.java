package lotto.model;

import lotto.model.config.LottoConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ScoreMap {
    private Map<Integer, Integer> scoreMap;

    public ScoreMap() {
        this.scoreMap = new HashMap<Integer, Integer>(){{
            put(0, 0);
            put(1, 0);
            put(2, 0);
            put(3, 0);
            put(4, 0);
            put(5, 0);
            put(6, 0);
        }};
    }

    public Set<Map.Entry<Integer, Integer>> getEntrySet(){
        return scoreMap.entrySet();
    }

    public void updateWithNumMatched(int numMatched) {
        scoreMap.put(numMatched, scoreMap.get(numMatched) + 1);
    }

    public int calculateReward() {
        int totalProfit = 0;
        for( Map.Entry<Integer, Integer> lottoResult : scoreMap.entrySet() ){
            int numMatched = lottoResult.getKey();
            int numMatchedLottoNumbers = lottoResult.getValue();
            totalProfit += calculateEachReward(numMatched, numMatchedLottoNumbers);
        }
        return totalProfit;
    }

    private int calculateEachReward(int key, int value){
        if(LottoConfig.winningRewards.get(key) == 0 || value == 0){
            return 0;
        }
        return LottoConfig.winningRewards.get(key) * value;
    }

}
