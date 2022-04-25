package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static final int LOTTO_PRICE_PER_ONE = 1000;

    private Store() {
    }

    public static List<Lotto> pay(int price) {
        final List<Lotto> lottos = new ArrayList<>();;
        int count = countOfLottos(price);

        while(count > 0) {
            lottos.add(LottoFactory.createLottoAutomatically());
            count--;
        }

        return lottos;
    }

    public static int countOfLottos(int price) {
        return price / LOTTO_PRICE_PER_ONE;
    }
}
