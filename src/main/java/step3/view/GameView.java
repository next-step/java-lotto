package step3.view;

import step3.common.WinningType;
import step3.domain.*;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = new Money(inputView.inputMoney());
        int lottoTicketCount = money.countLottoTicket();
        resultView.printLottoTicketCount(lottoTicketCount);

        LottoTicket[] lottoTickets = new LottoTicket[lottoTicketCount];
        WinningType[] winningTypes = new WinningType[lottoTicketCount];

        String winningNumberText = inputView.inputWinningNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberText);

        LottoTicketGenerator generator = new LottoTicketGenerator();
        for (int i=0; i<lottoTicketCount; i++) {
            LottoTicket lottoTicket = generator.generate();
            lottoTickets[i] = lottoTicket;
            System.out.println(lottoTickets[i]);
        }

        for (int i=0; i<lottoTicketCount; i++) {
            winningTypes[i] = winningNumbers.findWinningType(lottoTickets[i]);
        }

        double profit = money.calculateProfit(winningTypes);

        resultView.printResultStatistics(winningTypes);
        resultView.printResultProfit(profit);

    }
}
