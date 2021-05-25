package lotto;

import java.util.HashMap;

public class ResultAll {
    private HashMap<ResultScoreEnum, Integer> resultMap = new HashMap<>();

    public ResultAll() {
        resultMap.put(ResultScoreEnum.MISS, 0);
        resultMap.put(ResultScoreEnum.FIFTH, 0);
        resultMap.put(ResultScoreEnum.FOURTH, 0);
        resultMap.put(ResultScoreEnum.THIRD, 0);
        resultMap.put(ResultScoreEnum.SECOND, 0);
        resultMap.put(ResultScoreEnum.FIRST, 0);
    }

    public HashMap<ResultScoreEnum, Integer> getResult() {
        return resultMap;
    }

    public void won(WonCount wonCount) {
        ResultScoreEnum resultScoreEnum = ResultScoreEnum.valueOf(wonCount.wonCount(), wonCount.isBonusWon());
        resultMap.put(resultScoreEnum, resultMap.get(resultScoreEnum) + 1);
    }

    public float yield(int purchaseAmount) {
        return ((ResultScoreEnum.FIFTH.getWonMoney(resultMap.get(ResultScoreEnum.FIFTH)) +
                ResultScoreEnum.FOURTH.getWonMoney(resultMap.get(ResultScoreEnum.FOURTH)) +
                ResultScoreEnum.THIRD.getWonMoney(resultMap.get(ResultScoreEnum.THIRD)) +
                ResultScoreEnum.SECOND.getWonMoney(resultMap.get(ResultScoreEnum.SECOND)) +
                ResultScoreEnum.FIRST.getWonMoney(resultMap.get(ResultScoreEnum.FIRST))) / (float) purchaseAmount);
    }
}
