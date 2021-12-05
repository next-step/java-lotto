package lotto.domain;

import java.util.HashMap;

public class LottosRecord {
    private final HashMap<Prize, Integer> record;
    private final Double profit;

    private LottosRecord(HashMap<Prize, Integer> record, Double profit) {
        this.record = record;
        this.profit = profit;
    }

    public static LottosRecord of(Lottos lottos, WinningLotto winningLotto, LottoNumber bonus, int purchaseAmount) {
        return new LottosRecord(makeRecord(lottos, winningLotto, bonus), makeProfit(lottos, winningLotto, bonus, purchaseAmount));
    }

    private static HashMap<Prize, Integer> makeRecord(Lottos lottos, WinningLotto winningLotto, LottoNumber bonus) {
        HashMap<Prize, Integer> record = new HashMap<Prize, Integer>();
        for (Prize prize : Prize.values()) {
            int count = lottos.getCount(prize, winningLotto, bonus);
            record.put(prize, count);
        }
        return record;
    }

    private static Double makeProfit(Lottos lottos, WinningLotto winningLotto, LottoNumber bonus, int purchaseAmount) {
        return new Double(lottos.getTotalProfit(winningLotto, bonus)) / new Double(purchaseAmount);
    }

    public Double getProfit() {
        return profit;
    }

    public HashMap<Prize, Integer> getRecord() {
        return record;
    }
}
