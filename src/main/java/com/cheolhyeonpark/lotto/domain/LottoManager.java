package com.cheolhyeonpark.lotto.domain;

import java.util.stream.IntStream;

public class LottoManager {

    public static final int GAME_PRICE = 1_000;

    private final LottoNumbersList lottoNumbersList;

    public LottoManager(LottoNumbersList lottoNumbersList) {
        this.lottoNumbersList = lottoNumbersList;
    }

    public LottoNumbersList createLottoNumbers(int amount) {
        IntStream.range(0, amount / GAME_PRICE)
                .mapToObj(i -> new LottoNumbers())
                .forEach(lottoNumbersList::addLottoNumbers);
        return lottoNumbersList;
    }

    public GameResult getGameResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return lottoNumbersList.getGameResult(winningNumbers, bonusNumber);
    }
}
