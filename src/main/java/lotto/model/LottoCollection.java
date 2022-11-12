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

    public List<Rank> collectRanks(Lotto winningLotto) {
        return lottos.stream()
                .map(lotto -> lotto.countRank(winningLotto))
                .collect(Collectors.toList());
    }

    public void findSecond(MatchingCollection matchingCollection, LottoNumber bonusLotto) {
        matchingCollection.findSecondRank(this.lottos, bonusLotto);
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
