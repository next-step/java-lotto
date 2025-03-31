package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos add(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
        return this;
    }

    public Map<Rank, Integer> analyzeLottoStatistics(WinningLotto winningLotto) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);
        initializeStatistics(statistics);

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.determineLottoRank(lotto);
            statistics.put(rank, statistics.get(rank) + 1);
        }

        return statistics;
    }

    private void initializeStatistics(Map<Rank, Integer> statistics) {
        Arrays.stream(Rank.values()).forEach(rank -> statistics.put(rank, 0));
    }

    public int countAllLotto() {
        return lottos.size();
    }

    public int countManualLotto() {
        return (int) lottos.stream()
                .filter(lotto -> lotto.getLottoType() == LottoType.MANUAL)
                .count();
    }

    public int countAutoLotto() {
        return (int) lottos.stream()
                .filter(lotto -> lotto.getLottoType() == LottoType.AUTO)
                .count();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
