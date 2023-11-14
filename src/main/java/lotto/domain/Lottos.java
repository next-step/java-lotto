package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(Lottos autoLottos,
                  Lottos manaulLottos) {
        List<Lotto> list = new ArrayList<>();
        list.addAll(manaulLottos.getAll());
        list.addAll(autoLottos.getAll());
        this.lottos = list;
    }

    public List<Lotto> getAll() {
        return this.lottos;
    }

    public int size() {
        return this.lottos.size();
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
