package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    Money lottoMoney;
    PublishedLottoTicket publishedLottoTicket;
    LottoTicketCount ticketCount;
    WinningLotto winningLotto;
    List<Integer> winningLottoNumbers;
    LottoResult lottoResult = new LottoResult();

    public LottoController() {
        LottoMachine.getInstance();
    }

    public void start() {
        int money = InputView.inputMoney();
        lottoMoney = new Money(money);

        publishedLottoTicket = LottoShop.buyLotto(lottoMoney.getMoney());

        ticketCount = new LottoTicketCount(lottoMoney.getMoney());
        OutputView.printPurchaseTicketCount(ticketCount.getLottoTicketCount());
        OutputView.printLottoNumbers(publishedLottoTicket.getPublishedLottoTicket());

        winningLottoNumbers = InputView.inputWinningLottoNumbers();
        winningLotto = new WinningLotto(LottoMachine.createManualLottoNumbers(winningLottoNumbers));
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);

        OutputView.printLottoResults(lottoResult.getLottoResult());
        OutputView.printPrizeRate(lottoResult.calculatePrizeRate(lottoMoney.getMoney()));
    }
}
