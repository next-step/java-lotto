package lotto.domain;

import java.util.HashSet;
import java.util.Set;

public class Lottos {
    private final Set<Lotto> lottos = new HashSet<>();

    public void putLottos(Lotto lotto) {
        lottos.add(lotto);
    }

    public final Set<Lotto> getLottos() {
        return this.lottos;
    }
}
