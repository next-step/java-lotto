package lotto.model;


import lotto.enums.LottoReword;

import java.util.HashMap;
import java.util.Map;

public class LottoGameResult {
    private Map<LottoReword, Integer> results;

    public LottoGameResult() {
        results = initalizeResult();
    }

    public Map<LottoReword, Integer> getResults() {
        return results;
    }

    public void setRewordCount(Lotto lotto, WinningLotto winningLotto) {
        boolean isBonusMatch = winningLotto.isBonusMatch(lotto);
        int matchNumber = winningLotto.matchCount(lotto);

        LottoReword reword = LottoReword.valueOf(matchNumber, isBonusMatch);
        Integer count = results.containsKey(reword) ? results.get(reword) : 0;

        results.put(reword, ++count);
    }

    public float earningsRate(Integer totalPrice) {
        Integer totalReword = results.entrySet().stream()
                        .mapToInt(e -> e.getKey().computeReward(e.getValue()))
                        .sum();

        return totalReword / Float.valueOf(totalPrice);
    }

    private Map<LottoReword, Integer> initalizeResult() {
        LottoReword[] rewords = LottoReword.values();
        Map<LottoReword, Integer> initResult = new HashMap<>();

        for(int i = 0; i < rewords.length; i++) {
            initResult.put(rewords[i], 0);
        }

        return initResult;
    }
}
