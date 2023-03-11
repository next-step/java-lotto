package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoGame {
    private static final int PRICE = 1000;

    private final List<Lotto> lottos;
    private final int count;

    public LottoGame(int lottoPay) {
        count = lottoPay / PRICE;
        lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto());
        }
    }

    public int getBuyPrice() {
        return count * PRICE;
    }
}
