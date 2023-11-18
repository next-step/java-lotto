package lotto.domain;

import java.util.Arrays;
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
        return statistics.get(LottoPrize.ForthPrizeMoney) * LottoPrize.ForthPrizeMoney.getMoney()
                + statistics.get(LottoPrize.ThirdPrizeMoney) * LottoPrize.ThirdPrizeMoney.getMoney()
                + statistics.get(LottoPrize.SecondPrizeMoney) * LottoPrize.SecondPrizeMoney.getMoney()
                + statistics.get(LottoPrize.FirstPrizeMoney) * LottoPrize.FirstPrizeMoney.getMoney();
    }

    public float getProfitRate(Money buyMoney) {
        return (float) getReceiveMoney() / buyMoney.getMoney();
    }
}
