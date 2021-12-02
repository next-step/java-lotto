package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private static final int LOTTO_PRICE = 1000;

    public static List<Lotto> buy(int price) {
        int num = price / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }
}
