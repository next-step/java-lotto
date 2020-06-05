package study.lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottoList;

    private Lottos(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public static Lottos of(int num) {
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i < num; i++) {
            lottoList.add(Lotto.auto());
        }

        return new Lottos(lottoList);
    }

    public static Lottos of(List<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public static Lottos merge(Lottos manualLottos, Lottos autoLottos) {
        return Optional.ofNullable(manualLottos)
                .map(manual -> manual.addAll(autoLottos))
                .orElse(autoLottos);
    }

    private Lottos addAll(Lottos lottos) {
        lottoList.addAll(lottos.lottoList);

        return this;
    }

    public Map<LottoRank, Integer> countingByLottoRank(WinningLotto winningLotto, int bonusNumber) {
        Map<LottoRank, Integer> rankToCount = new HashMap<>();

        lottoList
            .forEach(lotto -> {
                LottoRank lottoRank = lotto.checkLottoRank(winningLotto, bonusNumber);
                rankToCount.put(lottoRank, rankToCount.getOrDefault(lottoRank, 0) + 1);
            });

        return rankToCount;
    }

    @Override
    public String toString() {
        return lottoList.stream().map(Lotto::toString).collect(Collectors.joining("\n"));
    }
}
