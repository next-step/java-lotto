package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public LottoMachine() {
    }

    public List<Lotto> purchaseLottos(Money money) {
        int purchasedCount = getPurchasedCount(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchasedCount; i++) {
            lottos.add(Lotto.newAutomatic());
        }
        return lottos;
    }

    private int getPurchasedCount(Money money) {
        int purchasableCount = money.getMoney() / LOTTO_PRICE;
        if (purchasableCount < 1) {
            throw new IllegalArgumentException("돈이 부족합니다.");
        }
        return purchasableCount;
    }
}
