package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class WinningDetails {

    private final Map<WinningPrice, Integer> winningDetails;

    public WinningDetails() {
        this.winningDetails = init();
    }

    public WinningDetails(final Map<WinningPrice, Integer> winningDetails) {
        this.winningDetails = winningDetails;
    }

    public void makeWinningDetails(final Lottos lottos, final WinningNumbers winningNumbers) {
        for (final Lotto lotto : lottos.getLottos()) {
            final int countOfMatch = lotto.findMatchNumberCount(winningNumbers);
            final WinningPrice winningPrice = WinningPrice.getWinningPrice(countOfMatch);
            winningDetails.put(winningPrice, winningDetails.get(winningPrice) + 1);
        }
    }

    public BigDecimal calculateProfit(final LottoAmount lottoAmount) {
        return calculateSum().divide(lottoAmount.toBigDecimal(), 2, RoundingMode.DOWN);
    }

    public Map<WinningPrice, Integer> getWinningDetails() {
        return winningDetails;
    }

    private Map<WinningPrice, Integer> init() {
        final HashMap<WinningPrice, Integer> winningDetails = new HashMap<>();
        for (final WinningPrice winningPrice : WinningPrice.values()) {
            winningDetails.put(winningPrice, 0);
        }
        return winningDetails;
    }

    public BigDecimal calculateSum() {
        final int sum = winningDetails.keySet().stream()
                .mapToInt(winningPrice -> winningPrice.getAmount() * winningDetails.get(winningPrice))
                .sum();
        return BigDecimal.valueOf(sum);
    }
}
