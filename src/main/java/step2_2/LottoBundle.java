package step2_2;

import java.util.HashSet;
import java.util.Set;

public class LottoBundle {

    private Set<Lotto> lottos;

    public LottoBundle(Money money) {
        lottos = new HashSet<>();
        while (money.canPurchase()) {
            lottos.add(Lotto.publish());
            money.purchaseLotto();
        }
    }
}
