package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int purchasePrice) {
        lottos = new ArrayList<>();
        int purchaseAmount = purchasePrice / 1000;
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(new Lotto(new RandomLottoNumberGenerator()));
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public int count() {
        return lottos.size();
    }

    public Map<Integer, Integer> countMatchResults(Lotto winningLotto) {
        Map<Integer, Integer> matchResults = new HashMap<>();
        for (Lotto lotto : lottos) {
            countIfWinningLotto(winningLotto, lotto, matchResults);
        }
        return matchResults;
    }

    private static void countIfWinningLotto(Lotto winningLotto, Lotto lotto,
        Map<Integer, Integer> matchResults) {
        if (lotto.isWinningLotto(winningLotto)) {
            int matchCount = lotto.countMatchWith(winningLotto);
            matchResults.put(matchCount, matchResults.getOrDefault(matchCount, 0) + 1);
        }
    }
}
