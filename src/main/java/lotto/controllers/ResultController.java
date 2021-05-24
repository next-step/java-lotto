package lotto.controllers;

import java.util.List;

import lotto.BonusNumber;
import lotto.LottoSponsor;
import lotto.Lotto;
import lotto.Purchase;
import lotto.Ticket;

public class ResultController implements Controller {

    private Lotto lotto;

    public ResultController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        delegateToLottoSponsor();
        toEndController();
    }

    private void delegateToLottoSponsor() {
        List<Ticket> automatedTickets = loadAutomatedTickets();
        Ticket winningTicket = loadWinningTicket();
        Purchase purchase = loadPurchase();
        BonusNumber bonusNumber = loadBonusNumber();

        LottoSponsor lottoSponsor = new LottoSponsor(automatedTickets, winningTicket, purchase, bonusNumber);
        lottoSponsor.show();
    }

    private Ticket loadWinningTicket() {
        return this.lotto.storage().loadWinningTicket();
    }

    private List<Ticket> loadAutomatedTickets() {
        return this.lotto.storage().loadAutomatedTickets();
    }

    private Purchase loadPurchase() {
        return this.lotto.storage().loadPurchase();
    }

    private BonusNumber loadBonusNumber() {
        return this.lotto.storage().loadBonusNumber();
    }

    private void toEndController() {
        this.lotto.toEndController();
    }
}
