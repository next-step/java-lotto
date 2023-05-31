package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;
    private final int manualCount;
    private final int autoCount;

    public Lottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        this.manualCount = manualLottos.size();
        this.autoCount = autoLottos.size();

        List<Lotto> allLottos = new ArrayList<>();
        allLottos.addAll(manualLottos);
        allLottos.addAll(autoLottos);
        this.lottos = Collections.unmodifiableList(allLottos);
    }

    public int manualCount() {
        return manualCount;
    }

    public int autoCount() {
        return autoCount;
    }

    public List<Lotto> allLottos() {
        return lottos;
    }
}
