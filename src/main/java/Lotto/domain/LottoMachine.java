package Lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private static final int MAX_RANK_SIZE = 7;

    public static Map<WinningRankInfo, Integer> checkWinningLotto(Lottos lottos, WinningLottoNumbers winningNumbers) {
        Map<WinningRankInfo ,Integer> winningLottoMap = new HashMap<>();

        List<Lotto> lottoList = lottos.getLottoList();
        for (Lotto lotto : lottoList) {
            int winningCount = lotto.checkWinningLottoNumbers(winningNumbers);
            int rank = MAX_RANK_SIZE - winningCount;

            WinningRankInfo winningRankInfo = WinningRankInfo.findWinningRank(rank);

            int cnt;
            if (winningLottoMap.containsKey(winningRankInfo)) {
                cnt = winningLottoMap.get(winningRankInfo);
                cnt += 1;
            } else {
                cnt = 1;
            }
            winningLottoMap.put(winningRankInfo, cnt);
        }

        return winningLottoMap;
    }

    public static int calcTotalWinningMoney(Map<WinningRankInfo, Integer> totalRankInfo) {
        int totalWinningMoney = 0;
        for (WinningRankInfo winningRankInfo : totalRankInfo.keySet()) {
            totalWinningMoney += winningRankInfo.sum(totalRankInfo.get(winningRankInfo));
        }
        return totalWinningMoney;
    }

    public static double calculateYield(int totalWinningMoney, int buyMoney) {
        return Double.parseDouble(String.format("%.3f", totalWinningMoney / (double)(buyMoney)));
    }
}
