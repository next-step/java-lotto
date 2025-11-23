package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(int count) {
        this(new ArrayList<>());
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public LottoResults calculateResults(Lotto winningLotto) {
        List<Integer> matchCountResults = Arrays.asList(0, 0, 0, 0);

        for (Lotto lotto : lottos) {
            int matchCount = lotto.countMatchNumbers(winningLotto);
            addMatchCount(matchCount, matchCountResults);
        }

        return new LottoResults(matchCountResults.get(0), matchCountResults.get(1), matchCountResults.get(2), matchCountResults.get(3));
    }

    private void addMatchCount(int matchCount, List<Integer> results) {
        if (matchCount >= 3 && matchCount <= 6) {
            int idx = matchCount - 3;
            results.set(idx, results.get(idx) + 1);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Lotto lotto : lottos) {
            sb.append(lotto.value().toString()).append("\n");
        }
        return sb.toString();
    }
}
