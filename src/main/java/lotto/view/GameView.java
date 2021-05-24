package lotto.view;

import lotto.common.WinningType;
import lotto.domain.*;

import java.util.List;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = new Money(inputView.inputMoney());
        int lottoTicketCount = money.countLottoTicket();
        resultView.printLottoTicketCount(money.countLottoTicket());

        LottoTickets lottoTickets = new LottoTickets(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets.printLottoTickets());

        LottoTicket winningLottoTicket = new LottoTicket(inputView.inputWinningNumber());
        List<WinningType> winningTypes = new LottoGamePlayer().play(winningLottoTicket, lottoTickets);
        resultView.printResultStatistics(winningTypes);
        resultView.printResultProfit(money.calculateProfit(winningTypes));

        inputView.close();
    }
}
