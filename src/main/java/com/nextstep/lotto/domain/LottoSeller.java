package com.nextstep.lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;

    private LottoSeller(){}

    public static int count(int price) {
        if (price < LOTTO_PRICE) {
            throw new IllegalArgumentException("최소 구매금액은 " + LOTTO_PRICE + "원 입니다.");
        }
        return price / LOTTO_PRICE;
    }

    public static List<Lotto> buyAutoLottos(int count) {
        return Stream.generate(RandomNumberFactory::createRandomNumbers)
                .limit(count)
                .map(Lotto::new)
                .collect(Collectors.toList());
    }
}
