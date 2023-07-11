package lotto.domain;

import java.util.List;

public class BoughtLottos {

    private final int count;
    private final List<Lotto> lottos;

    public BoughtLottos(List<Lotto> lottos) {
        this.count = lottos.size();
        this.lottos = lottos;
    }

    public int getCount() {
        return this.count;
    }
}
