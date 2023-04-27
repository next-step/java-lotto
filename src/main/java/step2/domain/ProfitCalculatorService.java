package step2.domain;

import step2.domain.model.Lotto.Lotto;
import step2.domain.model.Lotto.Lottos;
import step2.domain.model.WinningAmountByRank;

import java.util.HashMap;
import java.util.Map;

public class ProfitCalculatorService {
    public static final int FIRST_PLACE = 6;
    public static final int SECOND_PLACE = 5;
    public static final int THIRD_PLACE = 4;
    public static final int FOURTH_PLACE = 3;
    public static final int EMPTY_PLACE = 0;

    private Lottos lottos;
    private int purchaseAmount;
    private Map<String, Integer> winningCount = new HashMap<>();

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

    public double getProfit() {
        double winningAmount = 0;
        for (Lotto lotto : lottos.getLottos()) {
            WinningAmountByRank from = WinningAmountByRank.from(lotto.getWinningCount());
            winningCount.put(from.getKey(), winningCount.getOrDefault(from.getKey(), 0) + 1);
            winningAmount += from.getAmount();
        }
        return winningAmount / purchaseAmount;
    }

    public Map<String, Integer> getWinningCount() {
        return winningCount;
    }
}
