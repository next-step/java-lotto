package lotto.domain;

import static lotto.domain.Rank.createRankMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        lottos = new ArrayList<Lotto>();
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

    public String allLottosPrint() {
        return lottos.stream()
            .map(String::valueOf)
            .collect(Collectors.joining("\n"));
    }

}
