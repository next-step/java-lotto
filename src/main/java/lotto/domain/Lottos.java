package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos() {
        this.lottos = new ArrayList<>();
    }

    public Lottos(final List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public void add(final Lotto lotto) {
        this.lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public static int rankOfMatchSize(final Lottos lottos) {
        return lottos.getLottos().size();
    }

}
