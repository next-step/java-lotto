package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> addManualLottos(List<Lotto> manualLottos) {
        this.lottos.addAll(manualLottos);
        return new ArrayList<>(this.lottos);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(this.lottos);
    }
}
