package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class WinStatistics {
    private final Lottos lottos;
    private final WinNumbers winNumbers;

    public WinStatistics(Lottos lottos, WinNumbers winNumbers) {
        this.lottos = lottos;
        this.winNumbers = winNumbers;
    }

    public List<WinType> winStatistics() {
        return lottos.confirmWins(winNumbers);
    }

    public BigDecimal rateOfReturn() {
        BigDecimal lottoPurchaseAmount = new BigDecimal(this.lottos.purchaseAmount());
        return new BigDecimal(totalWinningAmount()).divide(lottoPurchaseAmount, 2, RoundingMode.DOWN);
    }

    private long totalWinningAmount() {
        long totalWinningAmount = 0;
        for (WinType winType : winStatistics()) {
            totalWinningAmount += winType.getWinnings();
        }
        return totalWinningAmount;
    }
}
