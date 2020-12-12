package com.nextstep.lotto.domain;

import java.util.List;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    private LottoSeller(){}

    public static int count(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("price is too less");
        }
        return price / LOTTO_PRICE;
    }

    public static Lottos buy(int count) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < count ; i ++ ) {
            List<Integer> randomNumbers = RandomNumberFactory.createRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }
}
