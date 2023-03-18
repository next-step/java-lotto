package domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.type.LottoRankResult;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    // public void calculateLottoRank(FirstPlaceLotto firstPlaceLotto) {
    // for (Lotto lotto : lottos) {
    // lotto.calculateLottoRank(firstPlaceLotto);
    // }
    // }

    public Map<LottoRankResult, Integer> getLottoRankCount(FirstPlaceLotto firstPlaceLotto) {
        Map<LottoRankResult, Integer> map = new HashMap<>();
        List.of(LottoRankResult.values()).stream()
                .forEach(it -> map.put(it, getLottoRankCount(it, firstPlaceLotto)));
        return map;
    }

    private int getLottoRankCount(LottoRankResult lottoRankAmount, FirstPlaceLotto firstPlaceLotto) {
        return lottos.stream()
                .filter(lotto -> lotto.calculateLottoRank(firstPlaceLotto) == lottoRankAmount)
                .toArray().length;
    }

    public int size() {
        return lottos.size();
    }

}
