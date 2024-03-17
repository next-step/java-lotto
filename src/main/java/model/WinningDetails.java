package model;

import java.util.HashMap;
import java.util.Map;

public class WinningDetails {

    private final Map<WinningPrice, Integer> winningDetails;

    public WinningDetails() {
        this.winningDetails = init();
    }

    public void makeWinningDetails(final Lottos lottos, final WinningNumbers winningNumbers) {
        for (final Lotto lotto : lottos.getLottos()) {
            final int countOfMatch = lotto.findMatchNumberCount(winningNumbers);
            final WinningPrice winningPrice = WinningPrice.getWinningPrice(countOfMatch);
            winningDetails.put(winningPrice, winningDetails.get(winningPrice) + 1);
        }
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
}
