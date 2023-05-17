package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final Money LOTTO_PRICE = new Money(1000);

    public static List<Lotto> buyLottos(Money money) {
        int buyCount = money.buyCount(LOTTO_PRICE);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
        return lottos;
    }
}
