package lotto;

import lotto.domains.Purchase;
import lotto.domains.Tickets;
import lotto.domains.WinningNumbers;

public class Model {

    private Purchase purchase;
    private Tickets automatedTickets;
    private WinningNumbers winningNumbers;

    public Model() {
    }

    public void savePurchase(Purchase purchase) {
        this.purchase = purchase;
    }

    public Purchase loadPurchase() {
        return this.purchase;
    }

    public void saveAutomatedTickets(Tickets automatedTickets) {
        this.automatedTickets = automatedTickets;
    }

    public Tickets loadAutomatedTickets() {
        return this.automatedTickets;
    }

    public void saveWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public WinningNumbers loadWinningNumbers() {
        return this.winningNumbers;
    }

}
