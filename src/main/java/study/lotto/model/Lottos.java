package study.lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int num) {
        return Stream.generate(Lotto::auto)
                .limit(num)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public void addAll(Lottos otherLottos) {
        lottos.addAll(otherLottos.lottos);
    }

    public Map<LottoRank, Integer> countingByLottoRank(WinningLottoInfo winningLottoInfo) {
        Map<LottoRank, Integer> rankToCount = new HashMap<>();

        lottos
            .forEach(lotto -> {
                LottoRank lottoRank = winningLottoInfo.checkLottoRank(lotto);
                rankToCount.put(lottoRank, rankToCount.getOrDefault(lottoRank, 0) + 1);
            });

        return rankToCount;
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
