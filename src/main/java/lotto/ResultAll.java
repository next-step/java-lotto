package lotto;

import java.util.HashMap;

public class ResultAll {
    private HashMap<ResultScoreEnum, Integer> resultMap = new HashMap<>();

    public ResultAll() {
        resultMap.put(ResultScoreEnum.THREE, 0);
        resultMap.put(ResultScoreEnum.FOUR, 0);
        resultMap.put(ResultScoreEnum.FIVE, 0);
        resultMap.put(ResultScoreEnum.FIVE_BONUS, 0);
        resultMap.put(ResultScoreEnum.SIX, 0);
    }

    public HashMap<ResultScoreEnum, Integer> getResult() {
        return resultMap;
    }

    public void won(WonCount wonCount) {
        if (wonCount.wonCount() == 3)
            resultMap.put(ResultScoreEnum.THREE, resultMap.get(ResultScoreEnum.THREE) + 1);
        if (wonCount.wonCount() == 4)
            resultMap.put(ResultScoreEnum.FOUR, resultMap.get(ResultScoreEnum.FOUR) + 1);
        if (wonCount.wonCount() == 5 && wonCount.bonusWonCount() == 0)
            resultMap.put(ResultScoreEnum.FIVE, resultMap.get(ResultScoreEnum.FIVE) + 1);
        if (wonCount.wonCount() == 5 && wonCount.bonusWonCount() == 1)
            resultMap.put(ResultScoreEnum.FIVE_BONUS, resultMap.get(ResultScoreEnum.FIVE_BONUS) + 1);
        if (wonCount.wonCount() == 6)
            resultMap.put(ResultScoreEnum.SIX, resultMap.get(ResultScoreEnum.SIX) + 1);
    }

    public float yield(int purchaseAmount) {
        return ((ResultScoreEnum.THREE.getWonMoney(resultMap.get(ResultScoreEnum.THREE)) +
                ResultScoreEnum.FOUR.getWonMoney(resultMap.get(ResultScoreEnum.FOUR)) +
                ResultScoreEnum.FIVE.getWonMoney(resultMap.get(ResultScoreEnum.FIVE)) +
                ResultScoreEnum.FIVE_BONUS.getWonMoney(resultMap.get(ResultScoreEnum.FIVE_BONUS)) +
                ResultScoreEnum.SIX.getWonMoney(resultMap.get(ResultScoreEnum.SIX))) / (float) purchaseAmount);
    }
}
