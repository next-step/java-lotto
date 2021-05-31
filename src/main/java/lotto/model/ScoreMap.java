package lotto.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
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

    public Set<Integer> getKeySet(){
        return scoreMap.keySet();
    }

    public Integer get(Integer key){
        return scoreMap.get(key);
    }

    public void updateByMatchCount(int matchCount) {
        scoreMap.put(matchCount, scoreMap.get(matchCount) + 1);
    }

    public int sumRewards() {
        int totalProfit = 0;
        for( Integer matchCount : scoreMap.keySet() ){
            totalProfit += multiplyRewardPriceByNumMatched(matchCount, scoreMap.get(matchCount));
        }
        return totalProfit;
    }

    private int multiplyRewardPriceByNumMatched(int matchCount, int actualNumMatched){
        int rewardPrice = LottoRank.of(matchCount).getPrize();
        if(rewardPrice == 0 || actualNumMatched == 0){
            return 0;
        }
        return rewardPrice * actualNumMatched;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreMap scoreMap1 = (ScoreMap) o;
        return Objects.equals(scoreMap, scoreMap1.scoreMap);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scoreMap);
    }
}
