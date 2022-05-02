package autolotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Results confirm(WinningLotto winningLotto) {
        Results results = new Results();

        for (Lotto lotto : lottos) {
            int numberOfWins = lotto.match(winningLotto);
            results.find(numberOfWins).ifPresent(Result::plusWinners);
        }
        return results;
    }

    public int cost() {
        return lottos.size() * LOTTO_PRICE;
    }

    public int getQuantity(int amount) {
        return amount / LOTTO_PRICE;
    }
}
