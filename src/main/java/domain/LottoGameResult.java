package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGameResult {
    private Map<LottoProfit, Integer> gameResult;

    public LottoGameResult() {
        gameResult = new HashMap<>();
        gameResult.put(LottoProfit.MISS, 0);
        gameResult.put(LottoProfit.FIFTH, 0);
        gameResult.put(LottoProfit.FOURTH, 0);
        gameResult.put(LottoProfit.THIRD, 0);
        gameResult.put(LottoProfit.SECOND, 0);
        gameResult.put(LottoProfit.FIRST, 0);
    }

    public void getMultipleResults(WinningLotto winningLotto, List<Lotto> userLottos) {

        for(Lotto userLotto : userLottos) {
            LottoMatch result = new LottoMatch(winningLotto, userLotto);
            LottoProfit profit = result.getProfit();
            gameResult.put(profit, gameResult.get(profit) + 1);
        }
    }

    public int getWinningCountOfResult(LottoProfit profit) {
        return gameResult.get(profit);
    }

    public double getProfitRate(LottoMoney money) {
        double totalProfit = 0.0;
        for (LottoProfit profit : LottoProfit.values()) {
            totalProfit += (double) getWinningCountOfResult(profit) * profit.getPrizeMoney();
        }
        return totalProfit;
    }

}
