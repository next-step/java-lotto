package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottoList) {
        lottos = lottoList;
    }

    public static Lottos of(List<List<Integer>> numbersList) {
        return new Lottos(numbersList.stream()
                .map(ManualLotto::of)
                .collect(Collectors.toList()));
    }

    public void add(Lottos lottos) {
        this.lottos.addAll(lottos.getLottos());
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
