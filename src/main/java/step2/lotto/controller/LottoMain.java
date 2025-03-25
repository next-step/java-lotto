package step2.lotto.controller;

import step2.lotto.model.LottoTicketList;
import step2.lotto.model.Money;
import step2.lotto.view.InputView;
import step2.lotto.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {

        InputView inputView = new InputView();
        String purchaseAmount = inputView.getPurchaseAmount();
        Money money = new Money(purchaseAmount);

        LottoApp lottoApp = new LottoApp();
        LottoTicketList lottoTicketList = lottoApp.buyLottoTickets(money);

        ResultView resultView = new ResultView();
        resultView.printLottoTicketCount(lottoTicketList);


    }

}
