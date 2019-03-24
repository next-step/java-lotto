package lotto.dto;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
    private Map<Integer, String> matchTable;
    private Money money;

    public LottoMatchResult(Money money) {
        this.money = money;

        matchTable = new HashMap<Integer, String>(4);
        matchTable.put(3, "THREE");
        matchTable.put(4, "FOUR");
        matchTable.put(5, "FIVE");
        matchTable.put(6, "SIX");
    }

    public void addMatchResult(int matchCount) {
        if (matchTable.containsKey(matchCount)) {
            LottoResult type = LottoResult.valueOf(matchTable.get(matchCount));
            type.setMatchCount();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        double totalPrice = 0;
        for (LottoResult type : LottoResult.values()) {
            totalPrice += (type.money * type.userMatchCount);
            sb.append(String.format("%s개 일치 (%s원)- %s개\n", type.matchCount, type.money, type.userMatchCount));
        }

        sb.append(String.format("총 수익률은 %.2f입니다.", (int) (totalPrice / money.getMoney() * 100) / 100.0));
        return sb.toString();
    }
}

enum LottoResult {
    THREE(3, 5000, 0), FOUR(4, 50000, 0), FIVE(5, 1500000, 0), SIX(6, 2000000000, 0);

    public final int matchCount;
    public final int money;
    public int userMatchCount;

    private LottoResult(int matchCount, int money, int userMatchCount) {
        this.matchCount = matchCount;
        this.money = money;
        this.userMatchCount = userMatchCount;
    }

    public void setMatchCount() {
        this.userMatchCount += 1;
    }
}
