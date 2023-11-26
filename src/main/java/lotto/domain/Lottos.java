package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(Lottos manualLottos, Lottos autoLottos) {
        this.lottos = new ArrayList<>(combine(manualLottos, autoLottos));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    private List<Lotto> combine(Lottos manualLottos, Lottos autoLottos) {
        List<Lotto> combinedLottos = new ArrayList<>();
        combinedLottos.addAll(manualLottos.getLottos());
        combinedLottos.addAll(autoLottos.getLottos());
        return combinedLottos;
    }

    public List<Lotto> getLottos() {
        return Collections.unmodifiableList(lottos);
    }
}
