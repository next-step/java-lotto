package study.lotto.domain;

import java.util.HashMap;
import java.util.Map;

import static study.lotto.domain.ScoreType.*;

public class LottoScore {
    private Map<ScoreType, Integer> scoreMap = new HashMap<>();

    public static LottoScore generate() {
        LottoScore lottoScore = new LottoScore();
        Map<ScoreType, Integer> scoreMap = lottoScore.getScoreMap();
        scoreMap.put(ZERO, 0);
        scoreMap.put(ONE, 0);
        scoreMap.put(TWO, 0);
        scoreMap.put(THREE, 0);
        scoreMap.put(FOUR, 0);
        scoreMap.put(FIVE, 0);
        scoreMap.put(SIX, 0);
        lottoScore.setScoreMap(scoreMap);
        return lottoScore;
    }

    public void addScore(ScoreType score) {
        Integer count = scoreMap.get(score);
        scoreMap.put(score, count + 1);
    }

    public Map<ScoreType, Integer> getScoreMap() {
        return scoreMap;
    }

    public void setScoreMap(Map<ScoreType, Integer> scoreMap) {
        this.scoreMap = scoreMap;
    }

    public Integer getTotalReward() {
        Integer totalReward = 0;
        for (Map.Entry<ScoreType, Integer> entry : scoreMap.entrySet()) {
            ScoreType lottoScoreType = entry.getKey();
            Integer count = entry.getValue();

            totalReward += lottoScoreType.getReward() * count;
        }
        return totalReward;
    }
}
