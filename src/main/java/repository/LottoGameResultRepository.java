package repository;

import domain.LottoPrize;

import java.util.EnumMap;
import java.util.Map;

public class LottoGameResultRepository {
    private EnumMap<LottoPrize, Integer> matchResult = new EnumMap<>(LottoPrize.class);

    public void saveResult(LottoPrize prize) {
        matchResult.put(prize, matchResult.getOrDefault(prize, 0) + 1);
    }

    public Map<LottoPrize, Integer> getAllResult() {
        return matchResult;
    }

    public void clearStore() {
        matchResult.clear();
    }
}
