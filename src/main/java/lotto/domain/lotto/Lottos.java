package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.lotto.generator.Generator;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public Lottos(final int lottoCount, final Generator generator) {
        this.lottos = setLottos(lottoCount, generator);
    }

    private List<Lotto> setLottos(final int lottoCount, final Generator generator) {
        return generator.generateLottos(lottoCount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
