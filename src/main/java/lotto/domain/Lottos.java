package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = Collections.unmodifiableList(lottoList);
    }

    public int getLottoListSize() {
        return lottoList.size();
    }

    public void drawLottos(Lotto luckyLotto) {
        for (Lotto lotto : lottoList) {
            lotto.draw(luckyLotto);
        }
    }

    public LottoStatistic makeStatistic() {
        Map<LottoRank, Integer> lottoStatisticMap = new HashMap<>();
        for (Lotto lotto : lottoList) {
            LottoRank rank = LottoRank.findByMatchingCount(lotto.getMatchingCount());
            putLottoStatisticMap(lottoStatisticMap, rank);
        }
        return new LottoStatistic(lottoStatisticMap);
    }

    private void putLottoStatisticMap(Map<LottoRank, Integer> lottoStatisticMap, LottoRank rank) {
        if (lottoStatisticMap.containsKey(rank)) {
            lottoStatisticMap.put(rank, lottoStatisticMap.get(rank) + 1);
            return;
        }
        lottoStatisticMap.put(rank, 1);
    }

    public List<String> toStringLottos() {
        return lottoList.stream()
                .map(Lotto::toStringNumbers)
                .collect(Collectors.toList());
    }

}