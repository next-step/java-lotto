package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoStorage {

    private final List<Lotto> lottos;
    private final Map<Integer, Integer> result = new HashMap<>();

    public LottoStorage(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Map<Integer, Integer> matchWithWinningLotto(final Lotto winningLotto) {
        this.lottos.forEach(lotto -> {
            int count = lotto.countSameNumbers(winningLotto);
            int value = result.getOrDefault(count, 1);
            result.put(count, value);
        });

        return result;
    }
}
