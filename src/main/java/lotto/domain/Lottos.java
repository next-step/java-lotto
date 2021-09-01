package lotto.domain;

import static lotto.domain.Rank.createRankMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int size() {
        return lottos.size();
    }

    public Map<Rank, Integer> calculateResult(WinLotto winLotto) {
        Map<Rank, Integer> result = createRankMap();
        lottos.stream()
            .map(winLotto::calculateRank)
            .forEach(rank -> result.put(rank, result.get(rank) + 1));
        return result;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public String printLottos() {
        return lottos.stream()
            .map(Lotto::printLotto)
            .collect(Collectors.joining("\n"));
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

}
