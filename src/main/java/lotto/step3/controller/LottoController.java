package lotto.step3.controller;

import lotto.step3.domain.Lotteries;
import lotto.step3.domain.LottoStore;
import lotto.step3.domain.Rank;
import lotto.step3.domain.WinningLotto;

import java.util.Map;

import static lotto.step3.domain.LottoStatistics.calculateRateOfProfit;
import static lotto.step3.domain.LottoStatistics.createLottoStatistics;
import static lotto.step3.view.InputView.*;
import static lotto.step3.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {

        int orderPrice = printInputOrderPrice();
        int orderManualCount = printInputOrderCount();

        LottoStore store = new LottoStore(orderPrice);
        Lotteries allLotteries = store.sellAllLotteries(orderManualCount, printInputLottoNumbers(orderManualCount));

        printOrderLottoCount(orderManualCount, store);
        printOrderLottoNumber(allLotteries);

        WinningLotto winningLotto = new WinningLotto(printInputWinningNumbers(), PrintInputBonusBall());

        Map<Rank, Integer> lottoStatistics = createLottoStatistics(winningLotto, allLotteries);
        printLottoStatics(lottoStatistics, calculateRateOfProfit(lottoStatistics, store.getOrderPrice()));

    }

}
