package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static Lottos sellAsMuchAsPossible(int money) {
        List<Lotto> lottos = new ArrayList<>();
        int maxAmount = money / 1000;
        for (int i = 0; i < maxAmount; i++) {
            Lotto lotto = sell(money);
            lottos.add(lotto);
        }

        return new Lottos(lottos);
    }

    private static Lotto sell(int money) {
        if (money < 1000) {
            throw new IllegalStateException("1000원 이상 있어야 구매할 수 있습니다");
        }
        return LottoFactory.generate();
    }
}
