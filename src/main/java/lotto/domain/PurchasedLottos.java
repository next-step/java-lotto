package lotto.domain;

import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> value;

    private PurchasedLottos(List<Lotto> lottos) {
        this.value = lottos;
    }

    public static PurchasedLottos valueOf(List<Lotto> lottos) {
        return new PurchasedLottos(lottos);
    }

    public List<Lotto> value() {
        return this.value;
    }
}
