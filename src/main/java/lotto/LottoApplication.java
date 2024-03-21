package lotto;

import calculator.domain.Calculator;
import comm.view.InputView;
import comm.view.ResultView;
import java.util.List;
import lotto.domain.LottoMachine;
import lotto.domain.LottoTickets;

public class LottoApplication {
    private static InputView inputView;
    private static Calculator calculator;
    private static LottoTickets lottoTickets;



    public static void main(String[] args) {
        int amount = InputView.requestPurchaseAmount();
        int ticketCount = LottoMachine.getTicketsCount(amount);
        ResultView.showTicketCount(ticketCount);

        lottoTickets = new LottoTickets(LottoMachine.purchaseLottoTickets(ticketCount));

        lottoTickets.showTickets();
        List<Integer> winningNumber = InputView.requestWinningNumbers();

        lottoTickets.showResult(winningNumber);
    }

}
