package lotto.domain.lotto;

import java.util.List;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto>... lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
