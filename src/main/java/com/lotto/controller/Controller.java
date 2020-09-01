package com.lotto.controller;

import com.lotto.domain.*;
import com.lotto.dto.DepositDTO;
import com.lotto.dto.WinningLotteryDTO;
import com.lotto.view.InputView;
import com.lotto.view.ResultView;

public class Controller {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        ResultView resultView = new ResultView();
        LotteryCommission lotteryCommission = new LotteryCommission();

        DepositDTO depositDTO = inputView.payAmount();
        Deposit deposit = depositDTO.of();
        System.out.println();

        Lotteries lotteries = lotteryCommission.publishLotteries(inputView.enterLotteriesManually(deposit), deposit);
        System.out.println();

        resultView.showPurchaseHistory(lotteries, deposit);
        System.out.println();

        WinningLotteryDTO winningLotteryDTO = inputView.setupWinningLottery();
        WinningLottery winningLottery = winningLotteryDTO.of();
        System.out.println();

        Statistics statistics = lotteryCommission.calculateStatistics(lotteries, winningLottery);
        resultView.showWinningStatistics(statistics);
    }
}
