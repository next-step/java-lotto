package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoStore {

    private static final Integer LOTTO_PRICE = 1000;

    public static List<Lotto> sell(int money) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < money / LOTTO_PRICE; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
