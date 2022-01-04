package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.util.Pair;

public class LottoResult {

    private Map<MatchType, Integer> matchResult;

    private float yield;

    private static final int LOTTO_PRICE = 1_000;
    private static final int LOTTO_MATCH_MINIMUM_BOUND = 3;


    public LottoResult(final List<Pair<Integer, Boolean>> matchResult) {
        setLottoResult(matchResult);
    }

    public Map<MatchType, Integer> getMatchResult() {
        return Collections.unmodifiableMap(matchResult);
    }

    public float getYield() {
        return yield;
    }

    public void setLottoResult(List<Pair<Integer, Boolean>> matchResult) {
        HashMap<MatchType, Integer> result = Arrays.stream(MatchType.matchType())
            .collect(Collectors
                .toMap(matchType -> matchType, matchType -> 0, (a, b) -> b, LinkedHashMap::new));
        matchResult.forEach(p -> result(result, p.getKey(), p.getValue()));
        int totalPrice = calculate(result);
        this.matchResult = result;
        this.yield = yield(totalPrice, matchResult.size());
    }

    private HashMap<MatchType, Integer> result(HashMap<MatchType, Integer> result,
        Integer matchCount, boolean matchBonusBall) {
        if (matchCount >= LOTTO_MATCH_MINIMUM_BOUND) {
            MatchType type = MatchType.of(matchCount, matchBonusBall);
            result.put(type, result.get(type) + 1);
        }
        return result;
    }

    private float yield(int totalPrice, int lottoSize) {
        return ((float) totalPrice) / (lottoSize * LOTTO_PRICE);
    }

    private int calculate(HashMap<MatchType, Integer> result) {
        int total = 0;
        for (Map.Entry<MatchType, Integer> entry : result.entrySet()) {
            total += (entry.getKey().getMoney() * entry.getValue());
        }
        return total;
    }
}
