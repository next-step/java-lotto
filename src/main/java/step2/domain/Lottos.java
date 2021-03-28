package step2.domain;

import step2.generator.NumberGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(NumberGenerator numberGenerator, Money money) {
        List<Lotto> lottos = new ArrayList<>();
        while (money.isPossibleBuyLotto()) {
            money.buyLotto();
            lottos.add(Lotto.from(numberGenerator));
        }
        return new Lottos(lottos);
    }

    public List<Prize> getPrizes(Lotto prizeLotto) {
        return lottos.stream()
                .map(lotto -> lotto.getMatchCount(prizeLotto))
                .map(matchCount -> Prize.findPrize(matchCount))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
