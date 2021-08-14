package lotto;


import java.util.List;
import lotto.domain.LottoGameVendor;
import lotto.domain.LottoGameWinnerCalculator;
import lotto.domain.LottoGameWinnerResult;
import lotto.domain.LottoPurchaseOrder;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketBundle;
import lotto.domain.Money;
import lotto.domain.TicketCount;
import lotto.domain.WinnerLottoInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        Money gameMoney = new Money(inputView.askMoneyAmount());
        TicketCount manualCount = new TicketCount(inputView.askHowManyManualTicketing());
        int[][] manualTicketNumbers = inputView.askManualTicketNumbers(manualCount);

        LottoPurchaseOrder order = new LottoPurchaseOrder(gameMoney, manualTicketNumbers);
        LottoTicketBundle ticketBundle = LottoGameVendor.buyLottos(order);
        outputView.showPlayerTicketNumbers(ticketBundle);

        int[] winnerNumbers = inputView.askWinnerNumbers();
        int bonusBallNumber = inputView.askBonusBallNumber();

        List<LottoTicket> allPlayerTickets = ticketBundle.getAllLottoTickets();
        WinnerLottoInfo winnerLottoInfo = new WinnerLottoInfo(winnerNumbers, bonusBallNumber);

        LottoGameWinnerResult winnerResult = LottoGameWinnerCalculator
            .calculate(winnerLottoInfo, allPlayerTickets);

        outputView.showWinnerResult(winnerResult);

        inputView.closeScanner();
    }

}
