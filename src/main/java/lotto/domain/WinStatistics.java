package lotto.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class WinStatistics {
    private final Lottos lottos;
    private final WinNumbers winNumbers;

    public WinStatistics(Lottos lottos, WinNumbers winNumbers) {
        this.lottos = lottos;
        this.winNumbers = winNumbers;
    }

    public List<WinType> winStatistics() {
        List<WinType> winTypes = new ArrayList<>();
        for (Lotto lotto : lottos.lottos()) {
            winTypes.add(winNumbers.confirmWin(lotto));
        }

        return winTypes;
    }

    public BigDecimal rateOfReturn() {
        BigDecimal lottoPurchaseAmount = new BigDecimal(this.lottos.lottoPurchaseAmount());
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
