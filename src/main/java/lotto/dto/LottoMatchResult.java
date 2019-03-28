package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private Map<LottoMatchType, Integer> matchTable;

    public LottoMatchResult() {
        matchTable = new HashMap<LottoMatchType, Integer>();
        for (LottoMatchType result : LottoMatchType.values()) {
            matchTable.put(result, 0);
        }
    }

    public void match(int matchCount) {
        for (LottoMatchType result : LottoMatchType.values()) {
            addMatchCount(matchCount, result);
        }
    }

    public void addMatchCount(int matchCount, LottoMatchType result) {
        if (result.matchCount == matchCount) {
            matchTable.put(result, matchTable.get(result) + 1);
        }
    }

    public double getLottoMatchRateOfResult(long money) {
        double totalPrice = 0.f;
        for (LottoMatchType result : LottoMatchType.values()) {
            totalPrice += (result.money * matchTable.get(result));
        }

        return (long) (totalPrice / money * 100) / 100.0;
    }

    public Map<LottoMatchType, Integer> getMatchTable() {
        return matchTable;
    }
}





