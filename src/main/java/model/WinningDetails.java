package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class WinningDetails {

    private static final int ROUNDING_PRECISION = 2;

    private final Map<Rank, Integer> winningDetails;

    public WinningDetails() {
        this.winningDetails = init();
    }

    public WinningDetails(final Map<Rank, Integer> winningDetails) {
        this.winningDetails = winningDetails;
    }

    public void makeWinningDetails(final Lottos lottos, final WinningNumbers winningNumbers) {
        for (final Lotto lotto : lottos.getLottos()) {
            final int countOfMatch = lotto.findMatchNumberCount(winningNumbers);
            final Rank rank = Rank.getWinningPrice(countOfMatch);
            winningDetails.put(rank, winningDetails.get(rank) + 1);
        }
    }

    public BigDecimal calculateProfit(final LottoAmount lottoAmount) {
        return calculateSum().divide(lottoAmount.toBigDecimal(), ROUNDING_PRECISION, RoundingMode.DOWN);
    }

    public Map<Rank, Integer> getWinningDetails() {
        return winningDetails;
    }

    private Map<Rank, Integer> init() {
        final HashMap<Rank, Integer> winningDetails = new HashMap<>();
        for (final Rank rank : Rank.values()) {
            winningDetails.put(rank, 0);
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
