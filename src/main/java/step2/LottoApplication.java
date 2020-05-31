package step2;

import step2.model.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoApplication {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    public static void main(String[] args) {
        Money purchaseMoney = InputView.getPurchaseMoney();

        LottoTickets lottoTickets = LOTTO_MACHINE.buyTicket(purchaseMoney);
        ResultView.printTickets(lottoTickets);

        List<LottoNumber> winningNumbers = InputView.getWinningNumbers();

        ResultView.printWinningStatistics(lottoTickets, winningNumbers);
        ResultView.printRateOfReturn(lottoTickets, winningNumbers, purchaseMoney);
    }
}
