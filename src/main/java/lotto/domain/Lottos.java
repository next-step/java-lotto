package lotto.domain;

import static lotto.domain.Rank.createRankMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

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

    public Lottos addLottos(List<Lotto> lottos) {
        List<Lotto> result = new ArrayList<>();
        Collections.copy(result, this.lottos);
        result.addAll(lottos);
        return new Lottos(result);
    }

    public Map<Rank, Integer> calculateResult(Lotto winLotto) {
        Map<Rank, Integer> result = createRankMap();
        lottos.stream()
            .map(lotto -> lotto.calculateWinCount(winLotto))
            .map(Rank::calculateLottoRank)
            .forEach(rank -> result.put(rank, result.get(rank)+1));
        return result;
    }

}
