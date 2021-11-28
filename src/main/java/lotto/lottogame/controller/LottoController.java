package lotto.lottogame.controller;

import lotto.lottogame.domain.Lotteries;
import lotto.lottogame.domain.LottoStatistics;
import lotto.lottogame.domain.LottoStore;
import lotto.lottogame.domain.WinningLotto;

import static lotto.lottogame.view.InputView.*;
import static lotto.lottogame.view.ResultView.*;

public class LottoController {

    public static void main(String[] args) {

        int orderPrice = printInputOrderPrice();
        int orderManualCount = printInputOrderCount();

        LottoStore store = new LottoStore(orderPrice);
        Lotteries allLotteries = store.sellAllLotteries(orderManualCount, printInputLottoNumbers(orderManualCount));

        printOrderLottoCount(orderManualCount, store);
        printOrderLottoNumber(allLotteries);

        WinningLotto winningLotto = new WinningLotto(printInputWinningNumbers(), PrintInputBonusBall());
        LottoStatistics statistics = winningLotto.createLottoStatistics(allLotteries, store.getOrderPrice());

        printLottoStatics(statistics);

    }

}
