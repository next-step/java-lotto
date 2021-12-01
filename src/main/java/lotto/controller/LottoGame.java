package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.LottoWinning;
import lotto.domain.Rank;
import lotto.domain.Store;
import lotto.domain.value.OrderPrice;

import java.util.Map;

import static lotto.view.InsertView.printInputIntro;
import static lotto.view.InsertView.printInputWinningNumbers;
import static lotto.view.InsertView.printInputBonusNumber;
import static lotto.view.ResultView.printOrderCount;

import static lotto.view.ResultView.printOrderLottoNumber;
import static lotto.view.ResultView.printWinningStatics;
import static lotto.view.ResultView.printRateOfReturn;

public class LottoGame {

    public void start() {

        String inputMoney = printInputIntro();
        OrderPrice lottoPrice = new OrderPrice(inputMoney);

        Store store = new Store();
        LottoTicket lottoTicket = store.purchaseTicket(lottoPrice);

        int lottoSize = lottoTicket.getLotto().size();
        printOrderCount(lottoSize);
        printOrderLottoNumber(lottoTicket);

        LottoWinning lottoWinning = LottoWinning.from(printInputWinningNumbers(), printInputBonusNumber());
        Map<Rank, Integer> prizeWinnersRepository = lottoWinning.createRepository(lottoTicket);

        printWinningStatics(prizeWinnersRepository);
        printRateOfReturn(lottoWinning.calculateRateOfProfit(prizeWinnersRepository, lottoPrice.getLottoPrice()));
    }
}
