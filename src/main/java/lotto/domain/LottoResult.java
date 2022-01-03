package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {

    private Map<MatchType, Integer> matchResult;

    private float yield;

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final int LOTTO_MATCH_MINIMUM_BOUND = 3;


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
        for (int count = LOTTO_MATCH_MINIMUM_BOUND; count <= LOTTO_NUMBER_SIZE; count++) {
            result.put(MatchType.of(count), frequency(matchCounts, count));
            totalPrice += calculate(result, count);
        }
        this.matchResult = result;
        this.yield = yield(totalPrice, matchCounts.size());
    }

    private float yield(int totalPrice, int lottoSize) {
        return ((float) totalPrice) / (lottoSize * LOTTO_PRICE);
    }

    private int frequency(List<Integer> matchCounts, int count) {
        return Collections.frequency(matchCounts, count);
    }

    private int calculate(HashMap<MatchType, Integer> result, int count) {
        return result.get(MatchType.of(count)) * MatchType.getMoneyByCount(count);
    }
}
