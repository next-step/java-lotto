package lotto;

import java.util.HashMap;

public class ResultAll {
    private HashMap<ResultScoreEnum, Integer> resultMap = new HashMap<>();

    public ResultAll() {
        ResultScoreEnum resultScoreEnum[] = ResultScoreEnum.values();
        for(ResultScoreEnum state : resultScoreEnum) {
            resultMap.put(state, 0);
        }
    }

    public HashMap<ResultScoreEnum, Integer> getResult() {
        return resultMap;
    }

    public void updateResult(SameNumberCountInALotto sameNumberCountInALotto) {
        ResultScoreEnum resultScoreEnum = ResultScoreEnum.valueOf(sameNumberCountInALotto.wonCount(), sameNumberCountInALotto.isBonusWon());
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
