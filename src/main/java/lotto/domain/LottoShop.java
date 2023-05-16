package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static List<Lotto> buyLottos(Money money) {
        int buyCount = money.buyCount(Lotto.PRICE);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < buyCount; i++) {
            Lotto lotto = LottoGenerator.generate();
            lottos.add(lotto);
        }
        return lottos;
    }
}
