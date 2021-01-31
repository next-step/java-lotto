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
        // TODO: (2단계) `LottoTicketOffice`에 수동 구입 메시지를 전송하고, 발행된 티켓들을 받는다.

        List<LottoTicket> lottoTickets = LottoTicketOffice.issue(new AutoPurchase(), amount);
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