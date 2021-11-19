package lotto.step3.controller;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.Lotto;
import lotto.step3.domain.LottoStatistics;
import lotto.step3.service.LottoService;

import java.util.Map;

import static lotto.step3.view.InputView.*;
import static lotto.step3.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {

        LottoService service = new LottoService();

        int orderPrice = printInputOrderPrice();
        Lotteries lotteries = service.buyLotteries(orderPrice);

        printOrderLottoCount(lotteries);
        printOrderLottoNumber(lotteries);

        Lotto winningNumbers = service.createWinningNumbers(printInputWinningNumbers());

        LottoStatistics lottoStatistics = service.createLottoStatistics(lotteries, winningNumbers, PrintInputBonusBall());

        Map<Integer, Integer> repository = service.createRepository(lottoStatistics);
        boolean isSecondPrizeWinners = service.isSecondPrizeWinners(lottoStatistics);
        int totalSecondPrizeWinner = service.totalSecondPrizeWinners(lottoStatistics);

        printWinningStatics(repository, isSecondPrizeWinners, totalSecondPrizeWinner);

        printRateOfReturn(service.calculateRateOfProfit(lottoStatistics, orderPrice));

    }

}
