package lotto;


import java.util.List;
import lotto.domain.LottoGameVendor;
import lotto.domain.LottoGameWinnerCalculator;
import lotto.domain.LottoGameWinnerResult;
import lotto.domain.LottoPurchaseOrder;
import lotto.domain.LottoTicket;
import lotto.domain.WinnerLottoInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameMain {

    public static void main(String[] args) {
        InputView inputView = InputView.getInstance();
        OutputView outputView = OutputView.getInstance();

        int moneyForGame = inputView.askMoneyAmount();
        int manualTicketCount = inputView.askHowManyManualTicketing();
        int[][] manualTicketNumbers = inputView.askManualTicketNumbers(manualTicketCount);

        LottoPurchaseOrder order = new LottoPurchaseOrder(moneyForGame, manualTicketNumbers);
        List<LottoTicket> playerTickets = LottoGameVendor.buyLottos(order);
        outputView.showPlayerTicketNumbers(playerTickets);

        int[] winnerNumbers = inputView.askWinnerNumbers();
        int bonusBallNumber = inputView.askBonusBallNumber();
        WinnerLottoInfo winnerLottoInfo = new WinnerLottoInfo(winnerNumbers, bonusBallNumber);

        LottoGameWinnerResult winnerResult = LottoGameWinnerCalculator
            .calculate(winnerLottoInfo, playerTickets);

        outputView.showWinnerResult(winnerResult);

        inputView.closeScanner();
    }

}
