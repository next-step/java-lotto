package lotto.domain;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_MATCH_MINIMUM_BOUND = 3;

    private Map<MatchType, Integer> result = defaultResult();

    private BigDecimal yield;

    public LottoResult(final List<MatchResult> matchResult) {
        setResult(matchResult);
    }

    public Map<MatchType, Integer> getResult() {
        return Collections.unmodifiableMap(result);
    }

    public BigDecimal getYield() {
        return yield;
    }

    public void setResult(List<MatchResult> matchResult) {
        matchResult.forEach(m -> result(m.getMatchCount(), m.isMatchBonusBall()));
        int totalPrice = calculate();
        this.yield = yield(totalPrice, matchResult.size());
    }

    private Map<MatchType, Integer> defaultResult() {
        Map<MatchType, Integer> defaultResult = new LinkedHashMap<>();
        for (MatchType matchType : MatchType.matchType()) {
            defaultResult.put(matchType, 0);
        }
        return defaultResult;
    }

    private void result(Integer matchCount, boolean matchBonusBall) {
        if (matchCount >= LOTTO_MATCH_MINIMUM_BOUND) {
            MatchType type = MatchType.of(matchCount, matchBonusBall);
            this.result.put(type, this.result.get(type) + 1);
        }
    }

    private BigDecimal yield(int totalPrice, int lottoSize) {
        BigDecimal total = new BigDecimal(totalPrice);
        return total.divide(new BigDecimal(lottoSize * LOTTO_PRICE), 2, BigDecimal.ROUND_HALF_UP);
    }

    private int calculate() {
        int total = 0;
        for (Map.Entry<MatchType, Integer> entry : this.result.entrySet()) {
            total += (entry.getKey().getMoney() * entry.getValue());
        }
        return total;
    }
}
