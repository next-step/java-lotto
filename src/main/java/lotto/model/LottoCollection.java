package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottos;

    public LottoCollection(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Integer> checkWinningNumber(List<String> winningNumber) {
        List<Integer> inventory = new ArrayList<>();
        for (Lotto lotto : lottos) {
            inventory.add(lotto.findWinner(winningNumber));
        }
        return inventory;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
