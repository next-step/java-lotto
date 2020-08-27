package com.lotto.controller;

import com.lotto.domain.Deposit;
import com.lotto.domain.Lottery;
import com.lotto.domain.LotteryCommission;
import com.lotto.domain.WinningLottery;
import com.lotto.view.InputView;
import com.lotto.view.ResultView;

import java.util.List;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LotteryCommission lotteryCommission = new LotteryCommission();

        Deposit deposit = inputView.payAmount();
        List<Lottery> lotteries = lotteryCommission.publishLotteries(deposit);
        resultView.showPurchaseHistory(lotteries);
        System.out.println();

        WinningLottery winningLottery = inputView.setupWinningLottery();
        System.out.println();

        resultView.showWinningStatistics(lotteries, winningLottery);
    }
}
