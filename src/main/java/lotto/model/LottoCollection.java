package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoCollection {
    private static final int MIN_LOTTO = 1;
    private final List<Lotto> lottos;

    public LottoCollection(List<Lotto> lottos) {
        validation(lottos);
        this.lottos = lottos;
    }

    public RankCount collectRanks(Lotto winningLotto) {
        Map<Rank, Integer> collect = lottos.stream()
                .map(it -> it.matchingRank(winningLotto))
                .collect(Collectors.groupingBy(it -> it, Collectors.reducing(0, e -> 1, Integer::sum)));

        return new RankCount(collect);
    }

    public void findSecond(RankCount rankCount, LottoNumber bonusLotto) {
        rankCount.findSecondRank(this.lottos, bonusLotto);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }

    private void validation(List<Lotto> lottos) {
        if (lottos.size() < MIN_LOTTO) {
            throw new IllegalArgumentException("구매 로또가 없습니다");
        }
    }
}
