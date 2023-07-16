package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Lottos {

    private static final int DEFAULT_VALUE = 0;
    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos createManualLottos(List<List<Integer>> manualLotto) {
        List<Lotto> number = new ArrayList<>();
        for (List<Integer> lotto : manualLotto) {
            number.add(Lotto.createManualLotto(lotto));
        }
        return new Lottos(number);
    }

    public int getLottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public Map<Rank, Integer> calculateMatchLotto(final WinningLotto winningLotto) {
        Map<Rank, Integer> result = initializeRankMap();
        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.compare(lotto);
            result.put(rank, result.get(rank) + 1);
        }
        return Collections.unmodifiableMap(result);
    }

    private Map<Rank, Integer> initializeRankMap() {
        Map<Rank, Integer> result = new HashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, DEFAULT_VALUE);
        }
        return result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }

    @Override
    public String toString() {
        return "Lottos{" +
            "lottos=" + lottos +
            '}';
    }
}
