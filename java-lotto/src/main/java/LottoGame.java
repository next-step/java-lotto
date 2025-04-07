import domain.Lotto.LottoResult;
import domain.Lotto.LottoService;
import domain.Lotto.LottoTicket;
import ui.OutputView;
import ui.InputView;

import java.util.List;


public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    public static void main(String[] args) {

//        StringCalculator calculator = new StringCalculator(new InputView(), new OutputView());
//        calculator.run();

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        LottoService lottoService = new LottoService();

        int purchaseAmount = inputView.getPurchaseAmount();
        List<LottoTicket> tickets = lottoService.generateLottoTickets(purchaseAmount / LOTTO_PRICE);
        outputView.printLottoTickets(tickets);

        LottoTicket winningTicket = inputView.getWinningTicket();
        LottoResult result = lottoService.calculateResults(tickets, winningTicket);
        outputView.printResult(result);

    }
}
