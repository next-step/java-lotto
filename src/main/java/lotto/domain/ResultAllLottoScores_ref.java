package lotto.domain;

import java.util.HashMap;

public class ResultAllLottoScores_ref {
    private HashMap<ResultScoreEnum_ref, Integer> resultMap = new HashMap<>();

    public ResultAllLottoScores_ref() {
        ResultScoreEnum_ref resultScoreEnumRef[] = ResultScoreEnum_ref.values();
        for(ResultScoreEnum_ref state : resultScoreEnumRef) {
            resultMap.put(state, 0);
        }
    }

    public HashMap<ResultScoreEnum_ref, Integer> result() {
        return resultMap;
    }

    public void updateResult(MatchStatusOfALotto_ref matchStatusOfALotto) {
        ResultScoreEnum_ref resultScoreEnumRef = matchStatusOfALotto.getResultScore();
        resultMap.put(resultScoreEnumRef, resultMap.get(resultScoreEnumRef) + 1);
    }

    public float yield(int purchaseAmount) {
        float sum = 0;
        for (ResultScoreEnum_ref resultScoreEnumRef : ResultScoreEnum_ref.values()) {
            sum += resultScoreEnumRef.getWonMoney(resultMap.get(resultScoreEnumRef));
        }
        return sum / (float) purchaseAmount;
    }
}
