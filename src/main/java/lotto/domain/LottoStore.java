package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static List<Lotto> sellAsMuchAsPossible(Money money) {
        List<Lotto> lottos = new ArrayList<>();

        int maxAmount = money.amount() / 1000;
        for (int i = 0; i < maxAmount; i++) {
            Lotto lotto = sell(money);
            lottos.add(lotto);
        }

        return lottos;
    }

    private static Lotto sell(Money money) {
        if (money.amount() < 1000) {
            throw new IllegalStateException("1000원 이상 있어야 구매할 수 있습니다");
        }
        money.spend(1000);
        return LottoFactory.generate();
    }
}
