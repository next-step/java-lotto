package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private static Map<LottoResult, Integer> matchTable;

    public static void createMatchTable() {
        matchTable = new HashMap<LottoResult, Integer>(4);
        for (LottoResult result : LottoResult.values()) {
            matchTable.put(result, 0);
        }
    }

    public static void addMatchResult(int matchCount) {
        for (LottoResult result : LottoResult.values()) {
            addMatchCount(matchCount, result);
        }
    }

    public static void addMatchCount(int matchCount, LottoResult result) {
        if (result.matchCount == matchCount) {
            matchTable.put(result, matchTable.get(result) + 1);
        }
    }

    public static Map<LottoResult, Integer> getMatchTable() {
        return matchTable;
    }

    public static String printLottResult() {
        StringBuilder sb = new StringBuilder();
        sb.append(UserLottoResult.userLottoResult());
        sb.append(UserLottoResult.userLottRateOfResult());
        return sb.toString();
    }
}

enum LottoResult {
    THREE(3, 5_000), FOUR(4, 50_000), FIVE(5, 1_500_000), SIX(6, 2_000_000_000);
    public final int matchCount;
    public final int money;

    private LottoResult(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }
}
