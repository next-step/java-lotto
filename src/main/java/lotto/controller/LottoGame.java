package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.domain.Rank;
import lotto.domain.Store;
import lotto.domain.value.OrderPrice;

import java.util.Map;

import static lotto.view.InsertView.printInputIntro;
import static lotto.view.InsertView.printInputWinningNumbers;
import static lotto.view.ResultView.*;

public class LottoGame {

    public void start() {

        String inputMoney = printInputIntro();
        OrderPrice lottoPrice = new OrderPrice(inputMoney);

        Store store = new Store();
        LottoTicket lottoTicket = store.purchaseTicket(lottoPrice);

        int lottoSize = lottoTicket.getLotto().size();
        printOrderCount(lottoSize);
        printOrderLottoNumber(lottoTicket);

        LottoWinning lottoWinning = LottoWinning.from(printInputWinningNumbers());
        Map<Rank, Integer> prizeWinnersRepository = lottoWinning.createRepository(lottoTicket);

        printWinningStatics(prizeWinnersRepository);
        printRateOfReturn(lottoWinning.calculateRateOfProfit(lottoTicket, lottoPrice.getLottoPrice()));
    }
}
