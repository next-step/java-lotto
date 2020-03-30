package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    private List<Lotto> lottos;

    public LottoMachine() {
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> purchaseLottos(Money money) {
        int purchasedCount = getPurchasedCount(money);
        for (int i = 0; i < purchasedCount; i++) {
            this.lottos.add(Lotto.newAutomatic());
        }
        return this.lottos;
    }

    private int getPurchasedCount(Money money) {
        int purchasableCount = money.getMoney() / LOTTO_PRICE;
        if (purchasableCount < 1) {
            throw new RuntimeException("돈이 부족합니다.");
        }
        return purchasableCount;
    }
}
