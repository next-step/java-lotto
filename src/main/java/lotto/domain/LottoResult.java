package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<MatchType, Integer> matchResult;

    private float yield;

    private static final int LOTTO_PRICE = 1000;

    public LottoResult(final List<Integer> matchCounts) {
        setLottoResult(matchCounts);
    }

    public Map<MatchType, Integer> getMatchResult() {
        return Collections.unmodifiableMap(matchResult);
    }

    public float getYield() {
        return yield;
    }

    private void setLottoResult(List<Integer> matchCounts) {
        HashMap<MatchType, Integer> result = new LinkedHashMap<>();
        int totalPrice = 0;
        for (int count = 3; count < 7; count++) {
            int frequency = Collections.frequency(matchCounts, count);
            result.put(MatchType.getMatchTypeByCount(count), frequency);
            totalPrice += frequency * MatchType.getMoneyByCount(count);
        }
        this.matchResult = result;
        this.yield = yield(totalPrice, matchCounts.size());
    }

    private float yield(int totalPrice, int lottoSize) {
        return ((float) totalPrice) / (lottoSize * LOTTO_PRICE);
    }
}
