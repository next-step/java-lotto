package lotto.step3.controller;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.Profit;
import lotto.step3.domain.Store;
import lotto.step3.service.LottoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static lotto.step3.view.InputView.*;
import static lotto.step3.view.ResultView.*;
import static lotto.step3.view.ResultView.printWinningStatics;

public class LottoController {

    public static void main(String[] args) {

        LottoService service = new LottoService();

        int orderPrice = printInputOrderPrice();
        Lotteries lotteries = service.buyLotteries(orderPrice);

        printOrderLottoCount(lotteries);
        printOrderLottoNumber(lotteries);

        Lotto winningNumbers = service.createWinningNumbers(printInputWinningNumbers());

        int bonusBall = PrintInputBonusBall();

        Map<Integer, Integer> totalCountOfMatch =  service.totalCountOfMatch(lotteries, winningNumbers);
        boolean isSecondPrizeWinners = service.isSecondPrizeWinners(lotteries, winningNumbers, bonusBall);
        int totalSecondPrizeWinner = service.totalSecondPrizeWinners(lotteries, winningNumbers, bonusBall);

        // 몇등에 몇명? / 2등이냐? / 2등 몇명이냐?
        printWinningStatics(totalCountOfMatch, isSecondPrizeWinners, totalSecondPrizeWinner);

        double rateOfReturn = service.calculateRateOfProfit(lotteries, winningNumbers, bonusBall, orderPrice);
        printRateOfReturn(rateOfReturn);

    }

}
