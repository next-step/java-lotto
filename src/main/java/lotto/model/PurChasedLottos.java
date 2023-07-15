package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class PurChasedLottos {
    private static final int LOTTO_UNIT = 1000;
    private final List<Lotto> lottos;
    private final int autoCount;
    private final int manualCount;


    public PurChasedLottos(final List<Lotto> lottos, final int autoCount, final int manualCount) {
        this.lottos = lottos;
        this.autoCount = autoCount;
        this.manualCount = manualCount;
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }

    public int getMoney() {
        return (autoCount + manualCount) * LOTTO_UNIT;
    }

    public int getAutoCount() {
        return autoCount;
    }

    public int getManualCount() {
        return manualCount;
    }

}
