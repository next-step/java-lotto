package com.lotto.controller;

import com.lotto.domain.LottoGroup;
import com.lotto.domain.LottoStatistics;
import com.lotto.domain.RequestPurchaseLotto;
import com.lotto.domain.WinningLotto;
import com.lotto.ui.InputView;
import com.lotto.ui.OutputView;

public class LottoManager {

    public void control() {
        RequestPurchaseLotto requestPurchaseLotto = inputPurchase();
        LottoGroup lottoGroup = LottoGroup.createLottoGroup(requestPurchaseLotto);

        OutputView.confirmBuyCount(requestPurchaseLotto);
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

    public RequestPurchaseLotto inputPurchase() {
        RequestPurchaseLotto requestPurchaseLotto = new RequestPurchaseLotto();

        repeatInputTotalPrice(requestPurchaseLotto);
        repeatInputManualLottoCount(requestPurchaseLotto);
        repeatInputManualNumbers(requestPurchaseLotto);

        return requestPurchaseLotto;
    }

    private String[] inputManualNumbers(RequestPurchaseLotto requestPurchaseLotto) {
        String[] sLottoList = new String[requestPurchaseLotto.getManualLottoCount()];
        for (int i = 0; i< requestPurchaseLotto.getManualLottoCount(); i++) {
            sLottoList[i] = InputView.inputDataFromConsole();
        }
        return sLottoList;
    }

    private void repeatInputManualNumbers(RequestPurchaseLotto requestPurchaseLotto) {
        try {
            OutputView.requireManualNumberList();
            requestPurchaseLotto.setLottoList(inputManualNumbers(requestPurchaseLotto));
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputManualNumbers(requestPurchaseLotto);
        }
    }

    private void repeatInputManualLottoCount(RequestPurchaseLotto requestPurchaseLotto) {
        try {
            OutputView.requireManualLottoCount();
            requestPurchaseLotto.setManualLottoCount(InputView.inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputManualLottoCount(requestPurchaseLotto);
        }
    }

    private void repeatInputTotalPrice(RequestPurchaseLotto requestPurchaseLotto) {
        try {
            OutputView.requireLottoPrice();
            requestPurchaseLotto.setTotalPrice(InputView.inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            repeatInputTotalPrice(requestPurchaseLotto);
        }
    }
}
