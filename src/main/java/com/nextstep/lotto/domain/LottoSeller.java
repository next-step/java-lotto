package com.nextstep.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    public static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_START_IDX = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MAX_COUNT = 45;

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
            List<Integer> randomNumbers = getRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    private static List<Integer> getRandomNumbers() {
        List<Integer> totalNumbers = getTotalNumbers();
        Collections.shuffle(totalNumbers);
        List<Integer> collectedNumbers = totalNumbers.subList(LOTTO_START_IDX, LOTTO_NUMBER_COUNT);
        Collections.sort(collectedNumbers);
        return collectedNumbers;
    }

    private static List<Integer> getTotalNumbers() {
        return Stream.iterate(1, i -> i + 1)
                .limit(LOTTO_MAX_COUNT).collect(Collectors.toList());
    }
}
