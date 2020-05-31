package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbersList {

    private final List<LottoNumbers> lottoNumbersList = new ArrayList<>();

    public void addLottoNumbers(LottoNumbers lottoNumbers) {
        lottoNumbersList.add(lottoNumbers);
    }

    public List<LottoNumbers> getLottoNumbersList() {
        return lottoNumbersList;
    }

    public int size() {
        return lottoNumbersList.size();
    }

    public LottoNumbers getNumbers(int index) {
        return lottoNumbersList.get(index);
    }

    public GameResult getGameResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        GameResult gameResult = new GameResult();
        lottoNumbersList.stream().map(lottoNumbers -> lottoNumbers.getRank(winningNumbers, bonusNumber)).forEach(gameResult::count);
        return gameResult;
    }
}
