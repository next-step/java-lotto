package com.lotto.controller;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.LottoStatistics;
import com.lotto.domain.ReqPurchaseLotto;
import com.lotto.domain.WinningLotto;
import com.lotto.ui.InputView;
import com.lotto.ui.OutputView;

public class LottoManager {

    public void control() {
        ReqPurchaseLotto reqPurchaseLotto = InputView.inputPurchase();
        LottoGroup lottoGroup = LottoGroup.createLottoGroup(reqPurchaseLotto);

        OutputView.confirmBuyCount(reqPurchaseLotto);
        OutputView.buyLottoList(lottoGroup.lottoList());

        WinningLotto winningLotto = createWinningLotto();

        OutputView.winningStatistics();
        LottoStatistics statistics = lottoGroup.statistics(winningLotto);
        OutputView.winningStatisticsDetail(statistics);
        OutputView.investment(statistics.yield());
    }

    private WinningLotto createWinningLotto() {
        WinningLotto winningLotto;
        winningLotto = repeatCreateWinningLotto();
        repeatSetBonusNumber(winningLotto);

        return winningLotto;
    }

    private void repeatSetBonusNumber(WinningLotto winningLotto) {
        OutputView.requireBonusNumbers();
        try {
            winningLotto.setBonusNumber(InputView.inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatSetBonusNumber(winningLotto);
        }
    }

    private WinningLotto repeatCreateWinningLotto() {
        WinningLotto winningLotto;

        OutputView.requireWinningNumbers();
        try {
            winningLotto = WinningLotto.createWinningLotto(InputView.inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            winningLotto = repeatCreateWinningLotto();
        }

        return winningLotto;
    }
}
