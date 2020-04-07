package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchaseResult {

    private final List<Lotto> manualLottos;
    private final List<Lotto> automaticLottos;

    public PurchaseResult(List<Lotto> manualLottos, List<Lotto> automaticLottos) {
        this.manualLottos = manualLottos;
        this.automaticLottos = automaticLottos;
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public List<Lotto> getAutomaticLottos() {
        return automaticLottos;
    }

    public List<Lotto> getAllLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(automaticLottos);
        return lottos;
    }
}
