package lotto.domain;

import java.util.*;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Lottos manualLottos, Lottos autoLottos) {
        this.lottos = new ArrayList<>(combine(manualLottos, autoLottos));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    private List<Lotto> combine(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> combinedLottos = new ArrayList<>();
        combinedLottos.addAll(manualLottos.getLottos());
        combinedLottos.addAll(autoLottos.getLottos());
        return combinedLottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    public Map<Rank, Integer> calculateWinningResult(Lotto winningLotto, LottoNumber bonusNumber) {
        Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = Rank.rankByCount(lotto.matchCount(winningLotto), lotto.contains(bonusNumber));
            rankCounts.put(rank, rankCounts.getOrDefault(rank, 0) + 1);
        }
        return rankCounts;
    }
}
