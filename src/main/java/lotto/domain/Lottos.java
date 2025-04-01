package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private List<Lotto> manualLottos;
    private List<Lotto> autoLottos;

    public Lottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        this.manualLottos = manualLottos;
        this.autoLottos = autoLottos;
    }

    public List<Lotto> getLottos() {
        List<Lotto> allLottos = new ArrayList<>();
        allLottos.addAll(manualLottos);
        allLottos.addAll(autoLottos);
        return allLottos;
    }

    public List<Lotto> getManualLottos() {
        return manualLottos;
    }

    public List<Lotto> getAutoLottos() {
        return autoLottos;
    }
}
