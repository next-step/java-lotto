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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(lottos.size() + "개를 구매했습니다\n");
        lottos.forEach(lotto -> sb.append(lotto + "\n"));
        return sb.toString();
    }
}
