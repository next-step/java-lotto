package study.lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

import static study.lotto.domain.ScoreType.*;

public class ScoreBoard {
    private static final int MAX_SCORE = 6;
    private BigDecimal inputMoney;
    private Map<ScoreType, Integer> scoreMap;

    public ScoreBoard(int money) {
        this.inputMoney = new BigDecimal(money);
        this.scoreMap = initScoreMap();
    }

    private Map<ScoreType, Integer> initScoreMap() {
        Map<ScoreType, Integer> scoreMap = new HashMap<>();
        for (int score = 0; score <= MAX_SCORE; score++) {
            scoreMap.put(of(score), 0);
        }
        return scoreMap;
    }

    public void addScore(ScoreType score) {
        Integer currentCount = scoreMap.get(score);
        Integer afterCount = currentCount + 1;
        scoreMap.put(score, afterCount);
    }

    public Map<ScoreType, Integer> getScoreMap() {
        return scoreMap;
    }

    public BigDecimal getTotalReward() {
        BigDecimal totalReward = new BigDecimal(0);
        for (Map.Entry<ScoreType, Integer> entry : scoreMap.entrySet()) {
            ScoreType scoreType = entry.getKey();
            Integer count = entry.getValue();
            totalReward = totalReward.add(new BigDecimal(scoreType.getReward() * count));
        }
        return totalReward;
    }

    public BigDecimal getRatioOfReturn() {
        return getTotalReward().divide(inputMoney, 4, RoundingMode.CEILING);
    }
}
