package com.lotto.controller;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoMachine;
import com.lotto.domain.LottoWinningNumbers;
import com.lotto.domain.LottoWinningStatistic;
import com.lotto.domain.ShuffleLottoExtractor;
import com.lotto.view.LottoView;

import java.util.List;

public class LottoGame {

    private LottoMachine lottoMachine;
    private LottoView lottoView;
    private LottoWinningStatistic lottoWinningStatistic;

    public LottoGame() {
        this.lottoMachine = new LottoMachine(new ShuffleLottoExtractor());
        this.lottoView = new LottoView();
        this.lottoWinningStatistic = new LottoWinningStatistic();
    }

    public void playLottoGame() {
        Integer countOfLotto = lottoView.inputPurchaseAmountOfLotto();
        List<Lotto> extractedLotto = lottoMachine.buyLotto(countOfLotto);
        lottoView.outputExtractedLotto(extractedLotto);

        String winningLottoNumbers = lottoView.inputWinningLottoNumbers();
        LottoWinningNumbers lottoWinningNumbers = LottoWinningNumbers.manipulateInputWinningLottoNumbers(winningLottoNumbers);

        for (Lotto lotto : extractedLotto) {
            this.lottoWinningStatistic.calculateLottoWinningStatics(lotto, lottoWinningNumbers);
        }

        this.lottoWinningStatistic.viewWinningStatistic();
    }
}
