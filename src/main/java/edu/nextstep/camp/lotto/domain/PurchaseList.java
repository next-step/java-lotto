package edu.nextstep.camp.lotto.domain;


import java.util.ArrayList;
import java.util.List;

public class PurchaseList {
    private static final int GAME_PRICE = 1000;

    private final Lottos lottos;

    private PurchaseList(int budget) {
        Lotto lotto = Lotto.of(
                List.of(LottoNumber.of(1), LottoNumber.of(2), LottoNumber.of(3), LottoNumber.of(4), LottoNumber.of(5), LottoNumber.of(6))
        );

        int amount = budget / GAME_PRICE;
        List<Lotto> lottoList = new ArrayList<>(amount);
        for (int i = 0; i < amount; i++) {
            lottoList.add(lotto);
        }

        this.lottos = Lottos.of(lottoList);
    }

    public static PurchaseList purchase(int budget) {
        if (budget < GAME_PRICE) {
            throw new IllegalArgumentException("invalid input: budget must be at least 1000, but " + budget);
        }

        if (budget % GAME_PRICE != 0) {
            throw new IllegalArgumentException("invalid input: budget must be multiple of 1000, but " + budget);
        }

        return new PurchaseList(budget);
    }

    public int amount() {
        return lottos.amount();
    }
}
