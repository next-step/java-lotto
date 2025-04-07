package lotto;

import lotto.domain.LottoService;
import lotto.domain.model.game.LottoGameResult;
import lotto.domain.model.lotto.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.Set;

public class LottoApplication {

    private final InputView inputView;
    private final ResultView resultView;
    private final LottoService service;

    public LottoApplication() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
        this.service = new LottoService();
    }

    public void start() {
        try {
            PurchaseAmount purchaseAmount = inputView.inputPurchaseAmount();
            TotalTicketCount totalTicketCount = getPurchaseInformation(purchaseAmount);
            List<LottoTicket> totalTickets = purchaseTickets(totalTicketCount);
            LottoGameResult result = playLottoGame(totalTickets);
            displayResults(purchaseAmount, result);
        } finally {
            inputView.close();
        }
    }

    private TotalTicketCount getPurchaseInformation(PurchaseAmount amount) {
        TicketCount purchasedTicketCount = TicketCount.from(amount, TicketPrice.standard());
        TicketCount manualCount = inputView.inputManualTicketCount();
        return new TotalTicketCount(purchasedTicketCount, manualCount);
    }

    private List<LottoTicket> purchaseTickets(TotalTicketCount totalTicketCount) {
        List<LottoTicket> manualTickets = inputView.inputManualTicketNumbers(totalTicketCount.getManualTicketCount());
        List<LottoTicket> totalTickets = service.purchaseTickets(manualTickets, totalTicketCount);
        resultView.printTicketsWithManualCount(totalTickets, totalTicketCount);
        return totalTickets;
    }

    private LottoGameResult playLottoGame(List<LottoTicket> totalTickets) {
        Set<LottoNumber> winningNumbers = inputView.inputWinningNumbers();
        BonusNumber bonusNumber = inputView.inputBonusNumber();
        return service.draw(totalTickets, new WinningLottoTicket(winningNumbers, bonusNumber));
    }

    private void displayResults(PurchaseAmount amount, LottoGameResult result) {
        resultView.printResult(amount, result);
    }

    public static void main(String[] args) {
        new LottoApplication().start();
    }
}
