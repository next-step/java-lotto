package step3.domain;

import step3.domain.model.Lotto.Lotto;
import step3.domain.model.Lotto.Lottos;
import step3.domain.model.WinningAmountByRank;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ProfitCalculatorService {
    // singleton 적용
    private static ProfitCalculatorService profitCalculatorService = null;

    public static ProfitCalculatorService createProfitCalculatorService() {
        if (Objects.isNull(profitCalculatorService)) {
            return new ProfitCalculatorService();
        }
        return profitCalculatorService;
    }


    public double calculatorProfit(Lottos lottos, int purchaseAmount) {
        double sum = lottos.getLottos()
                .stream()
                .mapToInt(lotto -> WinningAmountByRank.from(getWinningResult(lotto)).getAmount()).sum();

        return sum / purchaseAmount;
    }

    public Map<String, Integer> getWinningLotto(Lottos lottos) {
        Map<String, Integer> winningResult = new HashMap<>();
        for (Lotto lotto : lottos.getLottos()) {
            int winningCount = getWinningResult(lotto);
            WinningAmountByRank from = WinningAmountByRank.from(winningCount);
            winningResult.put(from.getKey(), winningResult.getOrDefault(from.getKey(), 0) + 1);
        }
        return winningResult;
    }

    public int getWinningResult(Lotto lotto) {
        if (isWinningRankSecond(lotto) & isLottoBonusNumber(lotto)) {
            return WinningAmountByRank.BONUS.getRank();
        }
        return lotto.getWinningResult();
    }

    private boolean isWinningRankSecond(Lotto lotto) {
        return lotto.getWinningResult() == WinningAmountByRank.SECOND.getRank();
    }

    private boolean isLottoBonusNumber(Lotto lotto) {
        return lotto.getBonusNumberResult() == WinningAmountByRank.BONUS.getRank();
    }
}
