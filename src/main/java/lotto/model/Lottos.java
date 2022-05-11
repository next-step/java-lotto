package lotto.model;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

public final class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos plus(Lottos manualLottos, Lottos autoLottos) {
        manualLottos.lottos.addAll(autoLottos.lottos);
        return manualLottos;
    }

    public List<Lotto> getLottos() {
        return this.lottos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(lottos, lottos1.lottos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottos);
    }
}
