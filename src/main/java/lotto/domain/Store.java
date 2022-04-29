package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public static final int LOTTO_PRICE_PER_ONE = 1000;

    private Store() {
    }

    public static Lottos pay(List<Lotto> manualLottos, int price) {
        final List<Lotto> lottos = new ArrayList<>(manualLottos);
        int count = countOfLottos(price) - manualLottos.size();
        while(count > 0) {
            lottos.add(LottoFactory.createLottoAutomatically());
            count--;
        }

        return Lottos.supplyLottos(lottos);
    }


    public static int countOfLottos(int price) {
        return price / LOTTO_PRICE_PER_ONE;
    }
}
