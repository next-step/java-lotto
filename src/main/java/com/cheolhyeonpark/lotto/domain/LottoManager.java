package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class LottoManager {

    public static final int GAME_PRICE = 1_000;

    private final List<LottoNumbers> lottoNumbersList = new ArrayList<>();
    private final AutoGenerator generator;

    public LottoManager(AutoGenerator generator) {
        this.generator = generator;
    }

    public void createLottoNumbers(int amount) {
        IntStream.range(0, amount / GAME_PRICE)
                .mapToObj(i -> generator.generate())
                .forEach(lottoNumbersList::add);
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }
}
