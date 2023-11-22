package lotto.domain;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {

    private final Map<LottoPrize, Integer> statistics = new HashMap<>();

    public LottoResult() {
        Arrays.stream(LottoPrize.values()).forEach(prize -> statistics.put(prize, 0));
    }

    public void add(LottoPrize prize) {
        statistics.put(prize, statistics.get(prize) + 1);
    }

    public int getPrizeCount(LottoPrize lottoPrize) {
        return statistics.get(lottoPrize);
    }

    private int getReceiveMoney() {
        return statistics.get(LottoPrize.FIFTH) * LottoPrize.FIFTH.getMoney()
                + statistics.get(LottoPrize.FOURTH) * LottoPrize.FOURTH.getMoney()
                + statistics.get(LottoPrize.THIRD) * LottoPrize.THIRD.getMoney()
                + statistics.get(LottoPrize.SECOND) * LottoPrize.SECOND.getMoney()
                + statistics.get(LottoPrize.FIRST) * LottoPrize.FIRST.getMoney();
    }

    public float getProfitRate(Money buyMoney) {
        return (float) getReceiveMoney() / buyMoney.getMoney();
    }

    public Map<LottoPrize, Integer> getStatistics() {
        return Collections.unmodifiableMap(statistics);
    }
}
