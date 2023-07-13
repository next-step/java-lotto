package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return List.copyOf(lottos);
    }
}
