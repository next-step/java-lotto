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
            addMatchCount(winningLotto.matchCount(lotto));
        });
    }

    private void addMatchCount(int matchCount) {
        statistics.put(matchCount, statistics.get(matchCount) + 1);
    }

    public int getMatchCount(int matchCount) {
        return statistics.get(matchCount);
    }

    public int getReceiveMoney() {
        return statistics.get(3) * ReceiveMoney.MATCH_3_RECEIVE_MONEY.getMoney()
                + statistics.get(4) * ReceiveMoney.MATCH_4_RECEIVE_MONEY.getMoney()
                + statistics.get(5) * ReceiveMoney.MATCH_5_RECEIVE_MONEY.getMoney()
                + statistics.get(6) * ReceiveMoney.MATCH_6_RECEIVE_MONEY.getMoney();
    }
}
