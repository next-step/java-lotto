package step2;

import step2.model.*;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoApplication {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    public static void main(String[] args) {
        Money purchaseMoney = InputView.getPurchaseMoney();
        LottoTickets lottoTickets = LOTTO_MACHINE.buyTicket(purchaseMoney);

        ResultView.printTickets(lottoTickets);

        WinningNumbers winningNumbers = InputView.getWinningNumbers();
        MatchResult matchResult = winningNumbers.calculateMatchResult(lottoTickets);

        ResultView.printMatchResult(matchResult);

        //ResultView.printWinningStatistics(lottoTickets, winningNumbers);
        //ResultView.printRateOfReturn(lottoTickets, winningNumbers, purchaseMoney);
    }
}
