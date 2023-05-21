package lotto.domain;

import java.util.List;

public class ManuallyCreatedLottos {

    private final List<Lotto> manuallyCreatedLottos;

    public ManuallyCreatedLottos(List<Lotto> manuallyCreatedLottos) {
        this.manuallyCreatedLottos = manuallyCreatedLottos;
    }

    public List<Lotto> getManuallyCreatedLottos() {
        return manuallyCreatedLottos;
    }
}
