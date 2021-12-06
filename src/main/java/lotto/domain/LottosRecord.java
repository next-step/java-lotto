package lotto.domain;

import java.text.DecimalFormat;
import java.util.HashMap;

public class LottosRecord {
    private final HashMap<Prize, Integer> record;
    private final Double profit;

    private LottosRecord(HashMap<Prize, Integer> record, Double profit) {
        this.record = record;
        this.profit = profit;
    }

    public static LottosRecord of(HashMap<Prize, Integer> record,double profit) {
        return new LottosRecord(record, profit);
    }

    public static HashMap<Prize, Integer> makeRecord(Lottos lottos, WinningLotto winningLotto, LottoNumber bonus) {
        HashMap<Prize, Integer> record = new HashMap<Prize, Integer>();
        for (Prize prize : Prize.values()) {
            int count = lottos.getCount(prize, winningLotto, bonus);
            record.put(prize, count);
        }
        return record;
    }

    public static Double calculateProfitRate(Double profit, int purchaseAmount) {
        return profit / new Double(purchaseAmount);
    }

    public String getProfit() {
        DecimalFormat form = new DecimalFormat("#.##");
        return form.format(profit);
    }

    public HashMap<Prize, Integer> getRecord() {
        return record;
    }
}
