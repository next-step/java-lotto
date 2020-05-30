package com.cheolhyeonpark.lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoManager {

    public static final int GAME_PRICE = 1_000;

    private final LottoNumbersList lottoNumbersList;
    private final AutoGenerator generator;

    public LottoManager(LottoNumbersList lottoNumbersList, AutoGenerator generator) {
        this.lottoNumbersList = lottoNumbersList;
        this.generator = generator;
    }

    public LottoNumbersList createLottoNumbers(int amount) {
        IntStream.range(0, amount / GAME_PRICE)
                .mapToObj(i -> generator.generate())
                .forEach(lottoNumbersList::addLottoNumbers);
        return lottoNumbersList;
    }

    public GameResult getGameResult(List<Integer> winningNumbers) {
        return lottoNumbersList.getGameResult(winningNumbers);
    }
}
