package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.domain.Store;

import java.util.Map;

import static lotto.view.InsertView.printInputIntro;
import static lotto.view.InsertView.printInputWinningNumbers;
import static lotto.view.ResultView.*;

public class LottoGame {

    public void start() {

        Store store = Store.of(printInputIntro());
        LottoTicket lottoTicket = store.purchaseTicket();

        printOrderCount(store.getOrderCount());
        printOrderLottoNumber(lottoTicket);

        LottoWinning lottoWinning = LottoWinning.from(printInputWinningNumbers());
        Map<Integer, Integer> prizeWinnersRepository = lottoWinning.createRepository(lottoTicket);

        printWinningStatics(prizeWinnersRepository);
        printRateOfReturn(lottoWinning.calculateRateOfProfit(lottoTicket, store.getOrderPrice().getOrderPrice()));
    }
}
