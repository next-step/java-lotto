package step2;

import step2.controller.LottoTicketMachine;
import step2.model.LottoTickets;
import step2.model.Money;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoApplication {

    private static final LottoTicketMachine lottoTicketMachine = LottoTicketMachine.newInstance();

    public static void main(String[] args) {
        int useAmount = InputView.getUseAmount();
        Money money = Money.valueOf(useAmount);

        LottoTickets lottoTickets = lottoTicketMachine.buy(money);

        ResultView.printTickets(lottoTickets);
        ResultView.printWinningStatistics(lottoTickets, InputView.getWinningNumbers());
    }
}
