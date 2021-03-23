package lotto.step2.domain;

import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(final List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getSize() {
        return lottos.size();
    }
}
