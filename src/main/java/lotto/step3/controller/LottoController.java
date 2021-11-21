package lotto.step3.controller;

import lotto.step3.domain.*;

import java.util.Map;

import static lotto.step3.view.InputView.*;
import static lotto.step3.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {

        int orderPrice = printInputOrderPrice();
        LottoStore store = new LottoStore(orderPrice);
        Lotteries lotteries = store.sellLotteries();

        printOrderLottoCount(lotteries);
        printOrderLottoNumber(lotteries);

        WinningLotto winningLotto = new WinningLotto(printInputWinningNumbers(), PrintInputBonusBall());

        Map<Integer, Integer> prizeWinnersRepository = winningLotto.createRepository(lotteries);
        int totalSecondPrizeWinner = winningLotto.totalSecondPrizeWinners(lotteries);

        printWinningStatics(prizeWinnersRepository, totalSecondPrizeWinner);
        printRateOfReturn(winningLotto.calculateRateOfProfit(lotteries, orderPrice));

    }

}
