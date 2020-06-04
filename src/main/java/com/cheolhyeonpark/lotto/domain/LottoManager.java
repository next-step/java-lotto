package com.cheolhyeonpark.lotto.domain;

import java.util.stream.IntStream;

public class LottoManager {

    public static final int GAME_PRICE = 1_000;

    private final LottoNumbersList lottoNumbersList;
    private final NumbersGenerator numbersGenerator;

    public LottoManager(LottoNumbersList lottoNumbersList, NumbersGenerator numbersGenerator) {
        this.lottoNumbersList = lottoNumbersList;
        this.numbersGenerator = numbersGenerator;
    }

    public LottoNumbersList createLottoNumbers(int amount) {
        IntStream.range(0, amount / GAME_PRICE)
                .mapToObj(i -> numbersGenerator.getAutoLottoNumbers())
                .forEach(lottoNumbersList::addLottoNumbers);
        return lottoNumbersList;
    }

    public GameResult getGameResult(String winningNumbers, int bonusNumber) {
        return lottoNumbersList.getGameResult(numbersGenerator.getWinningNumbers(winningNumbers),
                numbersGenerator.getBonusNumber(bonusNumber));
    }
}
