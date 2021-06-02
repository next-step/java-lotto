package lotto.model;

import java.util.*;

public class ScoreMap {
    private Map<LottoRank, Integer> scoreMap;

    public ScoreMap() {
        this.scoreMap = new LinkedHashMap<LottoRank, Integer>(){{
            put(LottoRank.MATCH_COUNT_ZERO, 0);
            put(LottoRank.MATCH_COUNT_ONE, 0);
            put(LottoRank.MATCH_COUNT_TWO, 0);
            put(LottoRank.MATCH_COUNT_THREE, 0);
            put(LottoRank.MATCH_COUNT_FOUR, 0);
            put(LottoRank.MATCH_COUNT_FIVE, 0);
            put(LottoRank.MATCH_COUNT_FIVE_AND_BONUS, 0);
            put(LottoRank.MATCH_COUNT_SIX, 0);
        }};
    }

    public Set<LottoRank> getKeySet(){
        return scoreMap.keySet();
    }

    public Integer getNumMatchCount(LottoRank lottoRank){
        return scoreMap.get(lottoRank);
    }

    public void updateByMatchCount(LottoRank lottoRank) {
        scoreMap.put(lottoRank, scoreMap.get(lottoRank) + 1);
    }

    public int sumRewards() {
        int totalProfit = 0;
        for( LottoRank lottoRank : scoreMap.keySet() ){
            totalProfit += multiplyRewardPriceByNumMatched(lottoRank, scoreMap.get(lottoRank));
        }
        return totalProfit;
    }

    private int multiplyRewardPriceByNumMatched(LottoRank lottoRank, int numMatchCount){
        int rewardPrice = lottoRank.getPrize();
        if(rewardPrice == 0 || numMatchCount == 0){
            return 0;
        }
        return rewardPrice * numMatchCount;
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
