package com.lotto.controller;

import com.lotto.domain.*;
import com.lotto.view.InputView;
import com.lotto.view.ResultView;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();

        Deposit deposit = inputView.payAmount();
        System.out.println();

        Lotteries lotteries = inputView.enterLotteriesManually(deposit);
        lotteries.publishLotteryAutomatically(deposit.getAutomaticLotteryCount());
        System.out.println();

        resultView.showPurchaseHistory(lotteries, deposit);
        System.out.println();

        WinningLottery winningLottery = inputView.setupWinningLottery();
        System.out.println();

        Statistics statistics = lotteries.calculateStatistics(winningLottery);
        resultView.showWinningStatistics(statistics);
    }
}
