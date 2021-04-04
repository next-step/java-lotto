package lotto.domain;

import lotto.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(final NumberGenerator numberGenerator, final Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isPossibleBuyLotto()) {
            lottos.add(Lotto.from(numberGenerator));
            money.buyLotto();
        }
        return new Lottos(lottos);
    }

    public int getRankCount(final WinningLotto winningLotto, final Rank criteriaRank) {
        return (int) lottos.stream()
                .map(lotto -> winningLotto.rank(lotto))
                .filter(rank -> rank.equals(criteriaRank))
                .count();
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
