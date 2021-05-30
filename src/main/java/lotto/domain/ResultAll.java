package lotto.domain;

import java.util.HashMap;

public class ResultAll {
    private HashMap<ResultScoreEnum, Integer> resultMap = new HashMap<>();

    public ResultAll() {
        ResultScoreEnum resultScoreEnum[] = ResultScoreEnum.values();
        for(ResultScoreEnum state : resultScoreEnum) {
            resultMap.put(state, 0);
        }
    }

    public HashMap<ResultScoreEnum, Integer> result() {
        return resultMap;
    }

    public void updateResult(SameNumberCountInALotto sameNumberCountInALotto) {
        ResultScoreEnum resultScoreEnum = sameNumberCountInALotto.getResultScore();
        resultMap.put(resultScoreEnum, resultMap.get(resultScoreEnum) + 1);
    }

    public float yield(int purchaseAmount) {
        float sum = 0;
        for (ResultScoreEnum resultScoreEnum : ResultScoreEnum.values()) {
            sum += resultScoreEnum.getWonMoney(resultMap.get(resultScoreEnum));
        }
        return sum / (float) purchaseAmount;
    }
}
