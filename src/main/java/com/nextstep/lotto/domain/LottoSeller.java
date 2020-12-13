package com.nextstep.lotto.domain;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    private LottoSeller(){}

    private static int count(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("price is too less");
        }
        return price / LOTTO_PRICE;
    }

    public static Lottos buy(int price) {
        int count = count(price);
        return  Stream.generate(RandomNumberFactory::createRandomNumbers)
                .limit(count)
                .map(Lotto::new)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Lottos::new));
    }
}
