package lotto;


import java.util.List;
import lotto.domain.LottoGameWinnerCalculator;
import lotto.domain.LottoGameWinnerResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketVendor;
import lotto.ticketingway.AutoNumberGeneratingWay;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        int moneyForGame = inputView.askMoneyAmount();
        LottoTicketVendor vendor = new LottoTicketVendor(new AutoNumberGeneratingWay());
        List<LottoTicket> playerTickets = vendor.buyLottoTickets(moneyForGame);
        outputView.showPlayerTicketNumbers(playerTickets);

        Integer[] winnerNumbers = inputView.askWinnerNumbers();
        LottoTicket winnerTicket = LottoTicket.generateByIntegerArray(winnerNumbers);
        LottoGameWinnerCalculator winnerCalculator = new LottoGameWinnerCalculator();
        LottoGameWinnerResult winnerResult = winnerCalculator
            .calculate(playerTickets, winnerTicket);

        outputView.showWinnerResult(winnerResult);

        inputView.closeScanner();
    }

}
