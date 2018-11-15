package lotto.model;


import enums.LottoReword;

import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {
    private static final int LOTTO_NUMBER_DIGIT = 6;

    private Map<Integer, Integer> results;

    public LottoGameResult() {
        results = initalizeResult();
    }

    public Map<Integer, Integer> getResults() {
        return results;
    }

    public void setRewordCount(Lotto lotto, WinningLotto winningLotto) {
        int matchNumber = lotto.matchCount(winningLotto);

        Integer count = results.containsKey(matchNumber) ? results.get(matchNumber) : 0;
        results.put(matchNumber, ++count);
    }

    public float earningsRate(Integer totalPrice) {
        LottoReword[] lottoRewords = LottoReword.values();
        Integer totalReword = results.entrySet().stream()
                        .mapToInt(e -> lottoRewords[e.getKey()].computeReward(e.getValue()))
                        .sum();

        return totalReword / Float.valueOf(totalPrice);
    }

    private Map<Integer, Integer> initalizeResult() {
        Map<Integer, Integer> initResult = new HashMap<>();

        for(int i = 1; i <= LOTTO_NUMBER_DIGIT; i++) {
            initResult.put(i, 0);
        }
        return initResult;
    }
}
