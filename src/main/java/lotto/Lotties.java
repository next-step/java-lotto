package lotto;

import java.util.*;

public class Lotties {
    private final List<Lotto> lotties;

    public Lotties(List<Lotto> lotties) {
        this.lotties = new ArrayList<>(lotties);
    }

    public int getCount() {
        return lotties.size();
    }

    public List<Lotto> getLotties() {
        return lotties;
    }

    public void sameNumberCount(List<Integer> winningNumber) {
        for (int i = 0; i < lotties.size(); i++) {
            lotties.get(i).getLottoRank(winningNumber);
        }
    }

}
