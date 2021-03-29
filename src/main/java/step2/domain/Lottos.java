package step2.domain;

import step2.generator.NumberGenerator;

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

    public int getPrizeCount(final Lotto prizeLotto, final Prize prize) {
        return (int) lottos.stream()
                .map(lotto -> lotto.getMatchCount(prizeLotto))
                .filter(matchCount -> matchCount == prize.getMatchCount())
                .count();
    }

    public int getLottoCount() {
        return lottos.size();
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
