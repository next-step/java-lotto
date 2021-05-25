package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 로또 목록.
 */
public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(List<Lotto> lottos, List<Lotto> manualPurchasedLottos) {
        this.lottos = collectLottos(lottos, manualPurchasedLottos);
    }

    private List<Lotto> collectLottos(List<Lotto> generatedLottos, List<Lotto> manualPurchasedLottos) {
        generatedLottos.addAll(manualPurchasedLottos);
        return new ArrayList<>(generatedLottos);
    }

    public List<Lotto> addLottos(List<Lotto> generatedLottos) {
        lottos.addAll(generatedLottos);
        return new ArrayList<>(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getSize() {
        return lottos.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        Lottos lottos1 = (Lottos) o;
        return Objects.equals(getLottos(), lottos1.getLottos());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLottos());
    }
}
