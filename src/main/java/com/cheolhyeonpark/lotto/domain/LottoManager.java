package com.cheolhyeonpark.lotto.domain;

import java.util.List;
import java.util.stream.IntStream;

public class LottoManager {

    public static final int GAME_PRICE = 1_000;

    private final LottoNumbersList lottoNumbersList;
    private final NumbersGenerator numbersGenerator;

    public LottoManager(LottoNumbersList lottoNumbersList, NumbersGenerator numbersGenerator) {
        this.lottoNumbersList = lottoNumbersList;
        this.numbersGenerator = numbersGenerator;
    }

    public LottoNumbersList createLottoNumbers(int amount, List<String> manualNumbers) {
        addManualNumbers(manualNumbers);
        addAutoNumbers(amount - GAME_PRICE * manualNumbers.size());
        return lottoNumbersList;
    }

    private void addManualNumbers(List<String> manualNumbers) {
        manualNumbers.stream().map(numbersGenerator::getManualLottoNumbers).forEach(lottoNumbersList::addLottoNumbers);
    }

    private void addAutoNumbers(int amount) {
        IntStream.range(0, amount / GAME_PRICE).mapToObj(i -> numbersGenerator.getAutoLottoNumbers())
                .forEach(lottoNumbersList::addLottoNumbers);
    }

    public GameResult getGameResult(String winningNumbers, int bonusNumber) {
        return lottoNumbersList.getGameResult(numbersGenerator.getWinningNumbers(winningNumbers),
                numbersGenerator.getBonusNumber(bonusNumber));
    }
}
