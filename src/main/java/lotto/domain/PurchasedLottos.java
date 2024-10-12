package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> value;

    private PurchasedLottos(List<Lotto> lottos) {
        this.value = lottos;
    }

    public static PurchasedLottos valueOf(List<Lotto> lottos) {
        return new PurchasedLottos(lottos);
    }

    public static PurchasedLottos newInstance() {
        return new PurchasedLottos(new ArrayList<>());
    }

    public List<Lotto> value() {
        return this.value;
    }

    public void addLotto(Lotto buytingLotto) {
        value.add(buytingLotto);
    }

}
