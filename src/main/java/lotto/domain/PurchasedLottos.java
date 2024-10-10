package lotto.domain;

import java.util.List;

public class PurchasedLottos {
    private List<Lotto> value;

    PurchasedLottos(List<Lotto> lottos) {
        this.value = lottos;
    }

    public static PurchasedLottos valueOf(List<Lotto> lottos) {
        return new PurchasedLottos(lottos);
    }

    public List<Lotto> value() {
        return this.value;
    }
}
