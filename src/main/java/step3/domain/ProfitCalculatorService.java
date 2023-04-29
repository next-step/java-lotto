package step3.domain;

import step3.domain.model.Lotto.Lotto;
import step3.domain.model.Lotto.Lottos;
import step3.domain.model.WinningAmountByRank;

import java.util.HashMap;
import java.util.Map;

public class ProfitCalculatorService {
    private Lottos lottos;
    private int purchaseAmount;
    private Map<String, Integer> winningResult = new HashMap<>();
    private double profit;

    public ProfitCalculatorService(Lottos lottos, int purchaseAmount) {
        this.lottos = lottos;
        this.purchaseAmount = purchaseAmount;
    }

    public static ProfitCalculatorService of(Lottos lottos, int purchaseAmount) {
        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("잘못된 급액 입니다.");
        }
        return new ProfitCalculatorService(lottos, purchaseAmount);
    }

    public void calculatorProfit() {
        double winningAmount = 0;
        for (Lotto lotto : lottos.getLottos()) {
            int winningCount = getWinningResult(lotto);
            WinningAmountByRank from = WinningAmountByRank.from(winningCount);
            winningResult.put(from.getKey(), winningResult.getOrDefault(from.getKey(), 0) + 1);
            winningAmount += from.getAmount();
        }
        profit = winningAmount / purchaseAmount;
    }

    public double getProfit() {
        return profit;
    }

    public Map<String, Integer> getWinningResult() {
        return winningResult;
    }

    public int getWinningResult(Lotto lotto) {
        if (isWinningRankSecond(lotto) & isLottoBonusNumber(lotto)) {
            return WinningAmountByRank.BONUS_PLACE;
        }
        return lotto.getWinningResult();
    }

    private boolean isWinningRankSecond(Lotto lotto) {
        return lotto.getWinningResult() == WinningAmountByRank.SECOND_PLACE;
    }

    private boolean isLottoBonusNumber(Lotto lotto) {
        return lotto.getBonusNumberResult() == WinningAmountByRank.BONUS_PLACE;
    }
}
