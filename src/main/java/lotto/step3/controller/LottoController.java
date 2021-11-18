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

        List<Integer> numbers = printInputWinningNumbers();
        Lotto winningNumbers = service.createWinningNumbers(numbers);

        int bonusBall = PrintInputBonusBall();
        service.validation(winningNumbers,bonusBall);

        Map<Integer, Integer> totalCountOfMatch =  service.totalCountOfMatch(lotteries, winningNumbers);
        boolean isSecondPrizeWinners = service.isSecondPrizeWinners(lotteries, winningNumbers, bonusBall);
        int totalSecondPrizeWinner = service.totalSecondPrizeWinners(lotteries, winningNumbers, bonusBall);

        printWinningStatics(totalCountOfMatch, isSecondPrizeWinners, totalSecondPrizeWinner);

        double rateOfReturn = service.calculateRateOfProfit(lotteries, winningNumbers, bonusBall, orderPrice);
        printRateOfReturn(rateOfReturn);

    }

}
