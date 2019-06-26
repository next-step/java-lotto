package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static int PRICE_LOTTO = 1000;

    private Map<Integer, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(int matchCount) {
        result.putIfAbsent(matchCount, 0);
        result.put(matchCount, result.get(matchCount) + 1);
    }

    public String getResultOf(int matchCount) {
        int earning = new LottoWin(matchCount).getEarning();
        int count = result.getOrDefault(matchCount, 0);

        StringBuilder builder = new StringBuilder();
        builder.append(matchCount);
        builder.append("개 일치 (");
        builder.append(earning);
        builder.append("원)- ");
        builder.append(count);
        builder.append("개");

        return builder.toString();
    }

    public int getProfitRate() {
        int paidPrice = result.size() * PRICE_LOTTO;

        int totalProfit = 0;
        for (Integer matchCount : result.keySet()) {
            LottoWin win = new LottoWin(matchCount);
            totalProfit += win.getEarning();
        }

        return totalProfit / paidPrice;
    }
}
