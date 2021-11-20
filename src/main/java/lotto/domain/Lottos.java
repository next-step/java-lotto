package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(int money, NumberGenerator generator) {
        List<Lotto> lottos = Stream.generate(() -> Lotto.from(generator))
                .limit(money / LOTTO_PRICE)
                .collect(Collectors.toList());

        return new Lottos(lottos);
    }

    public int lottoCount() {
        return lottos.size();
    }
}
