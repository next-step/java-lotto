package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(List<Lotto> lottoList) {
        this.lottoList = Collections.unmodifiableList(lottoList);
    }

    public Lottos(List<Lotto> manualLottos, List<Lotto> automaticLottos) {
        List<Lotto> combinedList = Stream.of(manualLottos, automaticLottos)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        this.lottoList = Collections.unmodifiableList(combinedList);
    }

    public int getLottoListSize() {
        return lottoList.size();
    }

    public LottoStatistic makeStatistic(Lotto luckyLotto, LottoNumber bonusNumber) {
        SortedMap<LottoRank, Integer> lottoStatisticMap = new TreeMap<>();
        for (Lotto lotto : lottoList) {
            int matchingCount = lotto.draw(luckyLotto);
            boolean matchBonus = lotto.drawBonus(matchingCount, bonusNumber);
            //LottoRank rank = LottoRank.findByMatchingCount(matchingCount);
            LottoRank rank = LottoRank.valueOf(matchingCount, matchBonus);
            putLottoStatisticMap(lottoStatisticMap, rank);
        }
        return new LottoStatistic(lottoStatisticMap);
    }

    public static void putLottoStatisticMap(Map<LottoRank, Integer> lottoStatisticMap, LottoRank rank) {
        if (rank.equals(LottoRank.MISS))
            return;
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