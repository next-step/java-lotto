package lotto.model;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoCollection {
    private static final int MIN_LOTTO = 1;
    private final List<Lotto> lottos;

    public LottoCollection(List<Lotto> lottos) {
        validation(lottos);
        this.lottos = lottos;
    }

    public MatchingCollection match(Lotto winningLotto) {
        EnumMap<Rank, Integer> enumMap = new EnumMap<>(Rank.class);

        List<Rank> ranks = collectRanks(winningLotto);
        for (Rank rank : ranks) {
            enumMap.put(rank, (int) ranks.stream()
                    .filter(countingMatch(rank))
                    .count());
        }

        return new MatchingCollection(enumMap);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private Predicate<Rank> countingMatch(Rank rank) {
        return collectedRank -> rank.count() == collectedRank.count();
    }

    private List<Rank> collectRanks(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.countRank(winningLotto))
                .collect(Collectors.toList());
    }

    private void validation(List<Lotto> lottos) {
        if (lottos.size() < MIN_LOTTO) {
            throw new IllegalArgumentException("구매 로또가 없습니다");
        }
    }
}
