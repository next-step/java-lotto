package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private Money lottoMoney;
    private PublishedLottoTicket publishedLottoTicket;
    private LottoTicketCount lottoTicketCount;
    private OutputView outputView;
    private LottoShop lottoShop;
    private LottoResult lottoResult;

    public LottoController() {
        lottoShop = LottoShop.getInstance();
        outputView = new OutputView();
    }

    public void start() {
        buyLottoTicket();

        outputView.printPurchaseTicketCount(lottoTicketCount.getLottoTicketCount())
                  .printLottoNumbers(publishedLottoTicket.getPublishedLottoTicket());

        drawLottoResult();

        outputView.printLottoResults(lottoResult.getLottoResult())
                  .printPrizeRate(lottoResult.calculatePrizeRate(lottoMoney.getMoney()));
    }

    private void buyLottoTicket(){
        lottoMoney = new Money(InputView.inputMoney());
        publishedLottoTicket = lottoShop.buyLotto(lottoMoney.getMoney());
        lottoTicketCount = LottoTicketCount.getInstance(lottoMoney.getMoney());
    }

    private void drawLottoResult() {
        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto(LottoMachine.createManualLottoNumbers(winningLottoNumbers));
        lottoResult = LottoResult.getInstance();
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);
    }
}
