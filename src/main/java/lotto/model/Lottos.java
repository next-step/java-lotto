package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Lottos {
    private static final int MIN_LOTTO = 1;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        validation(lottos);
        this.lottos = lottos;
    }

    private void validation(List<Lotto> lottos) {
        if (lottos.size() < MIN_LOTTO) {
            throw new IllegalArgumentException("구매 로또가 없습니다");
        }
    }

    public RankGroup collectRanks(WinningLotto winningLotto) {
        EnumMap<Rank, Integer> collect = lottos.stream()
                .map(lotto -> lotto.rank(winningLotto))
                .collect(Collectors.groupingBy(lotto -> lotto,
                        () -> new EnumMap<>(Rank.class),
                        Collectors.reducing(0, e -> 1, Integer::sum)));

        return new RankGroup(collect);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
