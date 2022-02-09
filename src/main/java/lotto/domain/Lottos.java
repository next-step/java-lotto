package lotto.domain;

import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public int getLottosSize() {
        return lottos.size();
    }
}
