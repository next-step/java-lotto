package step2.controller;

import step2.model.LottoMachine;
import step2.model.LottoTicketPrice;
import step2.model.LottoTickets;
import step2.model.Money;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoApplication {

    private static final LottoMachine LOTTO_MACHINE = LottoMachine.create(LottoTicketPrice.PRICE_1000);

    public static void main(String[] args) {
        int useAmount = InputView.getUseAmount();
        Money money = Money.valueOf(useAmount);

        LottoTickets lottoTickets = LOTTO_MACHINE.buyTicket(money);
        ResultView.printTickets(lottoTickets);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        ResultView.printWinningStatistics(lottoTickets, winningNumbers);
        ResultView.printRateOfReturn(lottoTickets, winningNumbers, money);
    }
}
