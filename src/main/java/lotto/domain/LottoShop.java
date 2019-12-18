package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoShop {

    public static final int SALE_PRICE = 1000;

    public List<Lotto> sell(int payment) {
        return createLottos(calculateLottoCount(payment));
    }

    private int calculateLottoCount(int payment) {
        return payment / SALE_PRICE;
    }

    private List<Lotto> createLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
