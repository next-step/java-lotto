package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.domain.lotto.generator.Generator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static Lottos combine(Lottos lottos1, Lottos lottos2) {
        return new Lottos(
            Stream.concat(lottos1.getLottos().stream(), lottos2.getLottos().stream())
                .collect(Collectors.toList()));
    }

    public Lottos(final int lottoCount, final Generator generator) {
        this.lottos = generator.generateLottos(lottoCount);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
