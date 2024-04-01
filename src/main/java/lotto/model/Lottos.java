package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private final List<Lotto> autoLottos;
    private final List<Lotto> manualLottos;

    public Lottos() {
        this.autoLottos = new ArrayList<>();
        this.manualLottos = new ArrayList<>();
    }

    public int size() {
        return autoLottos.size() + manualLottos.size();
    }

    public List<Lotto> getLottos() {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);

        return Collections.unmodifiableList(lottos);
    }


    public void addManualLottos(List<Lotto> buyManualLottos) {
        manualLottos.addAll(buyManualLottos);
    }

    public void addAutoLottos(List<Lotto> buyLottos) {
        autoLottos.addAll(buyLottos);
    }

    public int getAutoCount() {
        return this.autoLottos.size();
    }

    public int getManualCount() {
        return this.manualLottos.size();
    }
}
