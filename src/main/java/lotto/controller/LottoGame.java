package lotto.controller;

import lotto.domain.LottoTicket;
import lotto.domain.Store;

import static lotto.view.InsertView.printInputIntro;
import static lotto.view.ResultView.printOrderCount;
import static lotto.view.ResultView.printOrderLottoNumber;

public class LottoGame {

    public void start() {

        Store store = Store.of(printInputIntro());
        LottoTicket lottoTicket = store.purchaseTicket();

        printOrderCount(store.getOrderCount());
        printOrderLottoNumber(lottoTicket);
    }
}
