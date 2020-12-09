package com.nextstep.lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoSeller {
    private static final int LOTTO_PRICE = 1000;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_START_IDX = 0;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private LottoSeller(){}

    public static int count(int price) {
        return price / LOTTO_PRICE;
    }

    public static List<Lotto> buy(int count) {
        List<Lotto> lottos = new ArrayList<>();

        for (int ix = 0; ix < count ; ix ++ ) {
            List<Integer> randomNumbers = getRandomNumbers();
            lottos.add(new Lotto(randomNumbers));
        }
        return lottos;
    }

    private static List<Integer> getRandomNumbers() {
        List<Integer> lottoNumbers = createLottoNumbers();
        Collections.shuffle(lottoNumbers);
        List<Integer> collectedNumbers = lottoNumbers.subList(LOTTO_START_IDX, LOTTO_NUMBER_COUNT);
        Collections.sort(collectedNumbers);
        return collectedNumbers;
    }

    private static List<Integer> createLottoNumbers() {
        return Stream.iterate(1, i -> i + 1)
                .limit(MAX_NUMBER).collect(Collectors.toList());
    }
}
