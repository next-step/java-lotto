package Lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResultMachine {
    private static final int MAX_RANK_SIZE = 7;

    public static Map<WinningRankInfo, Integer> findWinningLotto(Lottos lottos, Lotto winningNumbers) {
        Map<WinningRankInfo , Integer> winningLottoRankMap = new HashMap<>();

        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            int rank = MAX_RANK_SIZE - lotto.findWinningLottoCnt(winningNumbers);

            WinningRankInfo winningRankInfo = WinningRankInfo.findWinningRank(rank);

            int cnt = getSameRankCnt(winningLottoRankMap, winningRankInfo);
            winningLottoRankMap.put(winningRankInfo, cnt);
        }

        return winningLottoRankMap;
    }

    private static int getSameRankCnt(Map<WinningRankInfo, Integer> winningLottoMap, WinningRankInfo winningRankInfo) {
        int cnt;
        if (winningLottoMap.containsKey(winningRankInfo)) {
            cnt = winningLottoMap.get(winningRankInfo);
            cnt += 1;
        } else {
            cnt = 1;
        }
        return cnt;
    }

    public static int calcTotalWinningMoney(Map<WinningRankInfo, Integer> totalRankInfo) {
        int totalWinningMoney = 0;
        for (WinningRankInfo winningRankInfo : totalRankInfo.keySet()) {
            totalWinningMoney += winningRankInfo.calcTotalWinningMoney(totalRankInfo.get(winningRankInfo));
        }
        return totalWinningMoney;
    }

    public static double calculateYield(int totalWinningMoney, int buyMoney) {
        return Double.parseDouble(String.format("%.3f", totalWinningMoney / (double)(buyMoney)));
    }
}
