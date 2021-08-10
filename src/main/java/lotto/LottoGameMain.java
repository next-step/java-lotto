package lotto;


import java.util.List;
import lotto.domain.LottoGameWinnerCalculator;
import lotto.domain.LottoGameWinnerResult;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketVendor;
import lotto.domain.WinnerNumberInfo;
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

        int[] winnerNumbers = inputView.askWinnerNumbers();
        int bonusBallNumber = inputView.askBonusBallNumber();
        WinnerNumberInfo winnerNumberInfo = new WinnerNumberInfo(winnerNumbers, bonusBallNumber);

        LottoGameWinnerCalculator winnerCalculator = new LottoGameWinnerCalculator(winnerNumberInfo);
        LottoGameWinnerResult winnerResult = winnerCalculator
            .calculate(playerTickets);

        outputView.showWinnerResult(winnerResult);

        inputView.closeScanner();
    }

}
