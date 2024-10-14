package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PurchasedLottos {
    private final List<Lotto> value;

    private PurchasedLottos(List<Lotto> lottos) {
        this.value = lottos;
    }

    public static PurchasedLottos valueOf(List<Lotto> lottos) {
        return new PurchasedLottos(Collections.unmodifiableList(lottos));
    }

    public static PurchasedLottos newInstance() {
        return new PurchasedLottos(List.of());
    }

    public List<Lotto> value() {
        return this.value;
    }

    public PurchasedLottos add(Lotto buytingLotto) {
        List<Lotto> addingLottos = new ArrayList<>(value);
        addingLottos.add(buytingLotto);
        return PurchasedLottos.valueOf(Collections.unmodifiableList(addingLottos));
    }
}
