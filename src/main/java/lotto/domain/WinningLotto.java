package lotto.domain;

import java.util.HashMap;
import java.util.Map;

public class WinningLotto {

    private static Map<Statistics, Integer> winResult;

    static {
        winResult = new HashMap<>();
    }

    public WinningLotto(Map<Statistics, Integer> winResult) {
        WinningLotto.winResult = winResult;
    }

    public static WinningLotto getMatchWin(Lottos lottos, LottoResult lottoResult) {
        lottos.getLottos().forEach(
            lotto -> matchCounting(lottoResult.matchNumbersCount(lotto), lottoResult.isBonusNumberMatch(lotto)));

        return new WinningLotto(winResult);
    }

    public Map<Statistics, Integer> winResult() {
        return winResult;
    }

    public static int getWinProfit() {
        int totalIncome = 0;

        for (Statistics statistics : Statistics.values()) {
            totalIncome += (winResult.getOrDefault(statistics, 0) * statistics.getMoney());
        }

        return totalIncome;
    }

    public static void matchCounting(int match, boolean bonus) {
        if (match < Statistics.FIFTH.match) {
            return;
        }

        Statistics statistics = Statistics.getReward(match, bonus);

        winResult.put(statistics, findStatistics(statistics) + 1);
    }

    public static int findStatistics(Statistics statistics) {
        return winResult.getOrDefault(statistics, 0);
    }
}
