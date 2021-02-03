package lotto.controller;

import lotto.domain.AutoPurchase;
import lotto.domain.GoldenTicket;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketOffice;
import lotto.domain.PurchaseAmount;
import lotto.domain.PurchaseResult;
import lotto.domain.WinnerStatistics;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public List<LottoTicket> purchaseLottoTickets() {
        PurchaseAmount amount = inputView.getPurchaseAmount();
        PurchaseResult manualPurchaseResult = inputView.getManualPurchasedTickets(amount);
        PurchaseResult autoPurchaseResult = LottoTicketOffice.issue(new AutoPurchase(), manualPurchaseResult.getChange());
        outputView.printLottoTickets(manualPurchaseResult, autoPurchaseResult);
        return Stream.concat(
                manualPurchaseResult.getLottoTickets().stream(), autoPurchaseResult.getLottoTickets().stream()
        ).collect(Collectors.toList());
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