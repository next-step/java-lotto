package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.generator.Generator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(final int lottoCount, final Generator generator) {
        this.lottos = generator.generateLottos(lottoCount);
    }

    public static Lottos combine(Lottos lottos, Lottos anotherLottos) {
        return new Lottos(
            Stream.concat(lottos.getLottos().stream(), anotherLottos.getLottos().stream())
                .collect(Collectors.toList()));
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
