package study.lotto.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
