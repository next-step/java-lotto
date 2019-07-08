package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private static int PRICE_LOTTO = 1000;

    private Map<Integer, Integer> result;

    public LottoResult() {
        this.result = new HashMap<>();
    }

    public void add(LottoWin win) {
        result.putIfAbsent(win.getCountOfMatch(), 0);
        result.put(win.getCountOfMatch(), result.get(win.getCountOfMatch()) + 1);
    }

    public String getResultOf(LottoWin win) {
        int earning = win.getEarning();
        int count = result.getOrDefault(win.getCountOfMatch(), 0);

        StringBuilder builder = new StringBuilder();
        builder.append(win.getCountOfMatch());
        builder.append("개 일치");
        if (win == LottoWin.SECOND) {
            builder.append(", 보너스 볼 일치");
        }
        builder.append(" (");
        builder.append(earning);

        builder.append("원) - ");
        builder.append(count);
        builder.append("개");

        return builder.toString();
    }

    public int getProfitRate() {
        int paidPrice = result.size() * PRICE_LOTTO;

        int totalProfit = 0;
        for (Integer matchCount : result.keySet()) {
            LottoWin win = LottoWin.valueOf(matchCount, false);
            totalProfit += win.getEarning();
        }

        return totalProfit / paidPrice;
    }
}
