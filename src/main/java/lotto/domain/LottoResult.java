package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResult {
    private static int PRICE_LOTTO = 1000;

    private Map<LottoWin, Integer> result;


    private LottoResult(Map<LottoWin, Integer> map) {
        this.result = map;
    }

    public static LottoResult of(List<LottoWin> wins) {
        HashMap<LottoWin, Integer> map = new HashMap<>();
        wins.stream()
                .forEach(win -> {
                    map.putIfAbsent(win, 0);
                    map.put(win, map.get(win) + 1);
                });

        return new LottoResult(map);
    }


    public Integer getResultOf(LottoWin win) {
        return result.getOrDefault(win, 0);
    }

    public double getProfitRate() {
        int countTickets = result.values().stream()
                .reduce((x, y) -> x + y)
                .orElseThrow(IllegalStateException::new);

        int paidPrice = countTickets * PRICE_LOTTO;

        double totalProfit = 0.0;
        for (LottoWin win : result.keySet()) {
            totalProfit += win.getEarning();
        }

        return totalProfit / paidPrice;
    }

    public LottoResult sum(LottoResult lottoResult) {
        lottoResult.result.keySet().stream()
                .forEach(matchCount -> {
                    result.putIfAbsent(matchCount, 0);
                    result.put(matchCount, result.get(matchCount) + 1);
                });

        return new LottoResult(result);
    }
}
