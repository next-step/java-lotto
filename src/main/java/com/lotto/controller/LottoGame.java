package com.lotto.controller;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoBonusBall;
import com.lotto.domain.LottoMachine;
import com.lotto.domain.LottoWinningNumbers;
import com.lotto.domain.LottoWinningStatistic;
import com.lotto.view.LottoView;

import java.util.List;

public class LottoGame {

    private LottoMachine lottoMachine;
    private LottoWinningStatistic lottoWinningStatistic;

    public LottoGame() {
        this.lottoMachine = new LottoMachine(new LottoView());
        this.lottoWinningStatistic = new LottoWinningStatistic();
    }

    public void playLottoGame() {
        List<Lotto> extractedLotto = this.lottoMachine.buyLotto();
        LottoWinningNumbers lottoWinningNumbers = this.lottoMachine.inputWinningLottoNumbers();
        LottoBonusBall lottoBonusBall = this.lottoMachine.inputLottoBonusBall();
        for (Lotto lotto : extractedLotto) {
            this.lottoWinningStatistic.calculateLottoWinningStatics(lotto, lottoWinningNumbers, lottoBonusBall);
        }
        this.lottoWinningStatistic.viewWinningStatistic();
        Double rateOfReturn = this.lottoWinningStatistic.getLottoRateOfReturn(extractedLotto.size());
        this.lottoWinningStatistic.viewLottoRateOfReturn(rateOfReturn);
    }
}
