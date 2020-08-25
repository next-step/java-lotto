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

        outputView.printPurchaseTicketCount(lottoTicketCount.getAutoLottoTicketCount(), lottoTicketCount.getManualLottoTicketCount())
                  .printLottoNumbers(publishedLottoTicket.getPublishedLottoTicket());

        drawLottoResult();

        outputView.printLottoResults(lottoResult.getLottoResult())
                  .printPrizeRate(lottoResult.calculatePrizeRate(lottoMoney.getMoney()));
    }

    private void buyLottoTicket() {
        lottoMoney = Money.valueOf(InputView.inputMoney());
        int manualLottoCount = InputView.inputManualLottoCount();
        lottoTicketCount = new LottoTicketCount.LottoTicketCountBuilder()
                .money(lottoMoney.getMoney())
                .manualLottoCount(manualLottoCount)
                .build();

        InputView.manualLottoNumberStart();
        publishedLottoTicket = lottoShop.buyLotto(lottoMoney.getMoney(), manualLottoCount);
    }

    private void drawLottoResult() {
        List<Integer> winningLottoNumbers = InputView.inputWinningLottoNumbers();
        WinningLotto winningLotto = new WinningLotto.WinningLottoBuilder()
                .winningLottoTicket(LottoMachine.createManualLottoNumbers(winningLottoNumbers))
                .bonusBall(InputView.inputBonusBall())
                .build();

        lottoResult = LottoResult.getInstance();
        lottoResult.analyzeLottoRank(publishedLottoTicket.getPublishedLottoTicket(), winningLotto);
    }
}
