package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Store {
    private static final int LOTTO_PRICE_PER_ONE = 1000;
    private final List<Lotto> lottos;

    public Store() {
        lottos = new ArrayList<>();
    }

    public void pay(int price) {
        int count = countOfLottos(price);

        while(count > 0) {
            lottos.add(LottoFactory.createLottoAutomatically());
            count--;
        }
    }

    public int countOfLottos(int price) {
        return price / LOTTO_PRICE_PER_ONE;
    }

    public List<Lotto> receive() {
        return Collections.unmodifiableList(lottos);
    }
}
