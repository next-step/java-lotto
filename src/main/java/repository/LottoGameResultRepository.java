package repository;

import domain.LottoPrize;

import java.util.HashMap;
import java.util.Map;

public class LottoGameResultRepository {
    private Map<LottoPrize, Integer> matchResult = new HashMap<>();

    public void saveResult(LottoPrize prize) {
        matchResult.put(prize, matchResult.getOrDefault(prize, 0) + 1);
    }

    public Map<LottoPrize, Integer> getAllResult() {
        return matchResult;
    }

    public void clearStore(){
        matchResult.clear();
    }
}
