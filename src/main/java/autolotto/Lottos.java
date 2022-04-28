package autolotto;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Results confirm(WinningLotto winningLotto) {
        Results results = new Results();
        results.initialize();

        for (Lotto lotto : lottos) {
            int numberOfWins = lotto.match(winningLotto);
            results.find(numberOfWins).ifPresent(Result::plusWinners);
        }
        return results;
    }
}
