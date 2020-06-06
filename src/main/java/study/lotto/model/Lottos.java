package study.lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(int num) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            lottos.add(Lotto.auto());
        }

        return new Lottos(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public void addAll(Lottos otherLottos) {
        lottos.addAll(otherLottos.lottos);
    }

    public Map<LottoRank, Integer> countingByLottoRank(WinningLotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> rankToCount = new HashMap<>();

        lottos
            .forEach(lotto -> {
                LottoRank lottoRank = lotto.checkLottoRank(winningLotto, bonusNumber);
                rankToCount.put(lottoRank, rankToCount.getOrDefault(lottoRank, 0) + 1);
            });

        return rankToCount;
    }

    @Override
    public String toString() {
        return lottos.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
