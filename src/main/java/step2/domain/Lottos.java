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

    public static Lottos from(NumberGenerator numberGenerator, Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isPossibleBuyLotto()) {
            money.buyLotto();
            lottos.add(Lotto.from(numberGenerator));
        }
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
