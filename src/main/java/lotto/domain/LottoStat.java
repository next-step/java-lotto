package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class LottoStat {

    private final Map<Integer, Integer> statistics = new HashMap<>();

    public LottoStat() {
        statistics.put(0, 0);
        statistics.put(1, 0);
        statistics.put(2, 0);
        statistics.put(3, 0);
        statistics.put(4, 0);
        statistics.put(5, 0);
        statistics.put(6, 0);
    }

    public void check(MyLottos myLottos, WinningLotto winningLotto) {
        myLottos.getLottos().forEach(lotto -> {
            addMatchCount(winningLotto.getPrize(lotto).getMatchCount());
        });
    }

    private void addMatchCount(int matchCount) {
        statistics.put(matchCount, statistics.get(matchCount) + 1);
    }

    public int getMatchCountResult(int matchCount) {
        return statistics.get(matchCount);
    }

    private int getReceiveMoney() {
        return statistics.get(3) * LottoPrize.ForthPrizeMoney.getMoney()
                + statistics.get(4) * LottoPrize.ThirdPrizeMoney.getMoney()
                + statistics.get(5) * LottoPrize.SecondPrizeMoney.getMoney()
                + statistics.get(6) * LottoPrize.FirstPrizeMoney.getMoney();
    }

    public float getProfitRate(Money buyMoney) {
        return (float) getReceiveMoney() / buyMoney.getMoney();
    }
}
