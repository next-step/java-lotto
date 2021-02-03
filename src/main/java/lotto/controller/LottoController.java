package lotto.controller;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<LottoTicket> purchaseLottoTickets() {
        PurchaseAmount amount = inputView.getPurchaseAmount();
        PurchaseResult autoPurchaseResult = LottoTicketOffice.issue(new AutoPurchase(), amount);
        List<LottoTicket> lottoTickets = autoPurchaseResult.getLottoTickets();
        outputView.printLottoTickets(lottoTickets);
        return lottoTickets;
    }

    public void draw(final List<LottoTicket> purchasedLottoTickets) {
        GoldenTicket goldenTicket = getGoldenTicketInput();
        WinnerStatistics winnerStatistics = new WinnerStatistics(goldenTicket, purchasedLottoTickets);
        outputView.printStatistics(winnerStatistics);
    }

    private GoldenTicket getGoldenTicketInput() {
        LottoTicket winningTicket = inputView.getWinningTicket();
        LottoNumber bonusNumber = inputView.getBonusNumber();
        return new GoldenTicket(winningTicket, bonusNumber);
    }
}