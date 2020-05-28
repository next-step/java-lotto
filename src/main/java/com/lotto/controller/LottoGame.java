package com.lotto.controller;

import com.lotto.domain.*;
import com.lotto.view.LottoView;

import java.util.List;

public class LottoGame {

    private LottoMachine lottoMachine;
    private LottoWinningStatistic lottoWinningStatistic;

    public LottoGame(LottoExtractor lottoExtractor) {
        this.lottoMachine = new LottoMachine(lottoExtractor, new LottoView());
        this.lottoWinningStatistic = new LottoWinningStatistic();
    }

    public void playLottoGame() {
        List<Lotto> extractedLotto = this.lottoMachine.buyLotto();
        LottoWinningNumbers lottoWinningNumbers = this.lottoMachine.inputWinningLottoNumbers();
        for (Lotto lotto : extractedLotto) {
            this.lottoWinningStatistic.calculateLottoWinningStatics(lotto, lottoWinningNumbers);
        }
        this.lottoWinningStatistic.viewWinningStatistic();
        Double rateOfReturn = this.lottoWinningStatistic.getLottoRateOfReturn(extractedLotto.size());
        this.lottoWinningStatistic.viewLottoRateOfReturn(rateOfReturn);
    }
}
