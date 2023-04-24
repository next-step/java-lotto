package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static study.lotto.domain.LottoScoreType.*;

public class LottoScore {
    private Map<LottoScoreType, Integer> scoreMap = new HashMap<>();

    public static LottoScore generate() {
        LottoScore lottoScoreSet = new LottoScore();
        Map<LottoScoreType, Integer> scoreMap = lottoScoreSet.getScoreMap();
        scoreMap.put(ZERO, 0);
        scoreMap.put(ONE, 0);
        scoreMap.put(TWO, 0);
        scoreMap.put(THREE, 0);
        scoreMap.put(FOUR, 0);
        scoreMap.put(FIVE, 0);
        scoreMap.put(SIX, 0);
        lottoScoreSet.setScoreMap(scoreMap);
        return lottoScoreSet;
    }

    public void addScore(LottoScoreType score) {
        Integer count = scoreMap.get(score);
        scoreMap.put(score, count + 1);
    }

    public Map<LottoScoreType, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(Map<LottoScoreType, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public Integer getTotalReward() {
        Integer totalReward = 0;
        for (Map.Entry<LottoScoreType, Integer> entry : scoreMap.entrySet()) {
            LottoScoreType lottoScoreType = entry.getKey();
            Integer count = entry.getValue();

            totalReward += lottoScoreType.getReward() * count;
        }
        return totalReward;
    }
}
