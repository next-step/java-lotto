package lotto.controllers;

import lotto.domains.Scores;
import lotto.domains.EarningRate;
import lotto.Lotto;
import lotto.domains.Purchase;
import lotto.domains.Tickets;
import lotto.domains.WinningNumbers;
import lotto.views.Reporter;

public class ResultController implements Controller {

    private Lotto lotto;

    public ResultController(Lotto lotto) {
        this.lotto = lotto;
    }

    @Override
    public void run() {
        Purchase purchase = loadPurchase();
        WinningNumbers winningNumbers = loadWinningNumbers();
        Tickets tickets = loadTickets();
        Scores scores = tickets.scores(winningNumbers);
        EarningRate earningRate = new EarningRate(scores, purchase);

        Reporter.report(scores, earningRate);

        toEndController();
    }

    private Tickets loadTickets() {
        return this.lotto.storage().loadTickets();
    }

    private Purchase loadPurchase() {
        return this.lotto.storage().loadPurchase();
    }

    private WinningNumbers loadWinningNumbers() {
        return this.lotto.storage().loadWinningNumbers();
    }

    private void toEndController() {
        this.lotto.toEndController();
    }
}
