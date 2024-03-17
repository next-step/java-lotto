package model;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<WinningPrice, Integer> makeWinningDetails(final WinningNumbers winningNumbers) {
        final HashMap<WinningPrice, Integer> winningDetails = new HashMap<>();
        for (WinningPrice winningPrice : WinningPrice.values()) {
            winningDetails.put(winningPrice, 0);
        }

        for (Lotto lotto : lottos) {
            final int countOfMatch = lotto.findMatchNumberCount(winningNumbers);
            final WinningPrice winningPrice = WinningPrice.getWinningPrice(countOfMatch);
            winningDetails.put(winningPrice, winningDetails.get(winningPrice) + 1);
        }
        return winningDetails;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
