package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    private static final int SALE_PRICE = 1000;

    public static LottoBundle sell(int payment) {
        return LottoBundle.of(createLottos(calculateLottoCount(payment)));
    }

    private static int calculateLottoCount(int payment) {
        return payment / SALE_PRICE;
    }

    private static List<Lotto> createLottos(int lottoCount) {

        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
