package com.lotto.controller;

import com.lotto.domain.*;
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
        Lotto lotto = repeatCreateLotto();
        return repeatCreateWinningLottoWithBonusNumber(lotto);
    }

    private WinningLotto repeatCreateWinningLottoWithBonusNumber(Lotto winningLotto) {
        WinningLotto retWinningLotto;
        OutputView.requireBonusNumbers();
        try {
            retWinningLotto = WinningLotto.createWinningLotto(winningLotto, InputView.inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            retWinningLotto = repeatCreateWinningLottoWithBonusNumber(winningLotto);
        }
        return retWinningLotto;
    }

    private Lotto repeatCreateLotto() {
        Lotto winningLotto;

        OutputView.requireWinningNumbers();
        try {
            winningLotto = Lotto.createLotto(InputView.inputDataFromConsole());
        } catch (RuntimeException exception) {
            OutputView.out(exception.getMessage());
            winningLotto = repeatCreateLotto();
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
