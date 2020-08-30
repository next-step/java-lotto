package com.lotto.controller;

import com.lotto.domain.*;
import com.lotto.view.InputView;
import com.lotto.view.ResultView;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LotteryCommission lotteryCommission = new LotteryCommission();

        Deposit deposit = inputView.payAmount();
        Lotteries lotteries = lotteryCommission.publishLotteries(deposit);
        resultView.showPurchaseHistory(lotteries);
        System.out.println();

        WinningLottery winningLottery = inputView.setupWinningLottery();
        System.out.println();

        Statistics statistics = lotteryCommission.calculateStatistics(lotteries, winningLottery);
        resultView.showWinningStatistics(statistics);
    }
}
