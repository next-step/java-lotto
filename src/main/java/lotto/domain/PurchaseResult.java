package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseResult {

    private final Lottos manualLottos;
    private final Lottos automaticLottos;

    public PurchaseResult(Lottos manualLottos, Lottos automaticLottos) {
        this.manualLottos = manualLottos;
        this.automaticLottos = automaticLottos;
    }

    public Lottos getManualLottos() {
        return manualLottos;
    }

    public Lottos getAutomaticLottos() {
        return automaticLottos;
    }

    public Lottos getAllLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos.getLottos());
        lottos.addAll(automaticLottos.getLottos());
        return new Lottos(lottos);
    }
}
