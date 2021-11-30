package lotto.domain.winning;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.HashMap;
import java.util.Map;

public class WinningLottoStats {

    public Map<Integer, Integer> getWinningStatsMap() {
        return winningStatsMap;
    }

    private final Map<Integer, Integer> winningStatsMap = new HashMap<>();

    public WinningLottoStats(Lottos compareLottos, Lotto winningLotto) {
        setWinningNumberCount(compareLottos, winningLotto);
        setWinningStatsMap(compareLottos);
    }

    private void setWinningStatsMap(Lottos lottos) {
        for (int matchingNumberCount : WinningPolicy.MATCHING_WINNINGAMOUNT_MAP.keySet()) {
            int lottoCount = (int) lottos.getLottos().stream().filter(lotto -> lotto.isWinningNumberEqual(matchingNumberCount)).count();
            winningStatsMap.put(matchingNumberCount, lottoCount);
        }
    }

    private void setWinningNumberCount(Lottos compareLottos, Lotto winningLotto) {
        compareLottos.getLottos().forEach(lotto -> lotto.getOverlappingLottoNum(winningLotto));
    }


    public String getProfitPercent(int totalPurchaseAmount) {
        int winningAmount = getTotalWinningAmount();
        double ratio = (double) winningAmount / totalPurchaseAmount;
        return String.format("%.2f", ratio);
    }

    private int getTotalWinningAmount() {
        int totalWinningAmount = 0;
        for (Map.Entry<Integer, Integer> entry : winningStatsMap.entrySet()) {
            int matchingCount = entry.getKey();
            int winningCount = entry.getValue();
            int winningAmount = WinningPolicy.MATCHING_WINNINGAMOUNT_MAP.get(matchingCount);
            totalWinningAmount += winningCount * winningAmount;
        }
        return totalWinningAmount;
    }
}
