package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

import java.util.ArrayList;
import java.util.List;

public class PurchaseResult {

    private final Lottos manualLottos;
    private final Lottos automaticLottos;

    public PurchaseResult(Lottos manualLottos, Lottos automaticLottos) {
        this.manualLottos = new Lottos(manualLottos.getLottos());
        this.automaticLottos = new Lottos(automaticLottos.getLottos());
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
