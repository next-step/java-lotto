package lotto.model;


import lotto.enums.LottoReword;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

    public float earningsRate(Money money) {
        Long totalReword = results.entrySet().stream()
                        .mapToLong(e -> e.getKey().computeReward(e.getValue()))
                        .sum();

        return money.earningsRate(totalReword);
    }

    private Map<LottoReword, Integer> initalizeResult() {
        LottoReword[] rewords = LottoReword.values();
        Map<LottoReword, Integer> initResult = new HashMap<>();

        for(int i = 0; i < rewords.length; i++) {
            initResult.put(rewords[i], 0);
        }

        return initResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGameResult that = (LottoGameResult) o;
        return Objects.equals(results, that.results);
    }

    @Override
    public int hashCode() {
        return Objects.hash(results);
    }
}
