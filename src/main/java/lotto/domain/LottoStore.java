package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    public static final int LOTTO_PRICE = 1000;

    public static Lottos sellAutomatic(Money money) {
        List<Lotto> lottos = new ArrayList<>();
        int maxAmount = money.maxPurchasableQuantity(LOTTO_PRICE);
        money.spend(LOTTO_PRICE * maxAmount);
        for (int i = 0; i < maxAmount; i++) {
            Lotto lotto = LottoFactory.generate();
            lottos.add(lotto);
        }
        return new Lottos(lottos);
    }

    public static Lottos sellManual(List<Lotto> lottos, Money money) {
        money.spend(LOTTO_PRICE * lottos.size());
        return new Lottos(lottos);
    }
}
