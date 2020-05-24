package com.lotto.controller;

import com.lotto.domain.Lotto;
import com.lotto.domain.LottoMachine;
import com.lotto.domain.LottoStatistic;
import com.lotto.view.LottoView;

import java.util.List;

public class LottoGame {

    private LottoMachine lottoMachine;
    private LottoView lottoView;
    private LottoStatistic lottoStatistic;

    public LottoGame() {
        this.lottoMachine = new LottoMachine();
        this.lottoView = new LottoView();
        this.lottoStatistic = new LottoStatistic();
    }

    public void playLottoGame() {
        Integer countOfLotto = lottoView.inputPurchaseAmountOfLotto();
        List<Lotto> extractedLotto = lottoMachine.buyLotto(countOfLotto);
        lottoView.outputExtractedLotto(extractedLotto);
        String winningLottoNumbers = lottoView.inputWinningLottoNumbers();

    }


}
