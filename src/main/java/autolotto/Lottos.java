package autolotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos = new ArrayList<>();

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public Map<Integer, Integer> confirm(WinningLotto winningLotto) {
        Map<Integer, Integer> results = new HashMap<>();
        for (int key=3; key < 7; key++) {
            results.put(key, 0);
        }

        for (Lotto lotto : lottos) {
            int key = lotto.match(winningLotto);
            results.compute(key, (k, v) -> v+1);
        }
        return results;
    }
}
