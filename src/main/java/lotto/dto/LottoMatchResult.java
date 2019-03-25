package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private Map<LottoResult, Integer> matchTable;
    private Money money;

    public LottoMatchResult(Money money) {
        this.money = money;
        matchTable = new HashMap<LottoResult, Integer>(4);

        for (LottoResult result : LottoResult.values()) {
            matchTable.put(result, 0);
        }
    }

    public void addMatchResult(int matchCount) {
        String matchString = matchNumberToString(matchCount);

        if (matchString != "NOTHING") {
            LottoResult result = LottoResult.valueOf(matchString);
            matchTable.put(result, matchTable.get(result) + 1);
        }
    }

    public String matchNumberToString(int matchCount) {
        switch (matchCount) {
            case 3:
                return "THREE";
            case 4:
                return "FOUR";
            case 5:
                return "FIVE";
            case 6:
                return "SIX";
            default:
                return "NOTHING";
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double totalPrice = 0;

        for (LottoResult lottoType : matchTable.keySet()) {
            int userMatchCount = matchTable.get(lottoType);
            totalPrice += (lottoType.money * userMatchCount);
            sb.append(String.format("%s개 일치 (%s원)- %s개\n", lottoType.matchCount, lottoType.money, userMatchCount));
        }

        sb.append(String.format("총 수익률은 %.2f입니다.", (int) (totalPrice / money.getMoney() * 100) / 100.0));
        return sb.toString();
    }
}

enum LottoResult {
    THREE(3, 5000), FOUR(4, 50000), FIVE(5, 1500000), SIX(6, 2000000000);
    public final int matchCount;
    public final int money;

    private LottoResult(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }
}
