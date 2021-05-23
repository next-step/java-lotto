package step3.view;

import step3.common.WinningType;
import step3.domain.LottoTicket;
import step3.domain.LottoTicketGenerator;
import step3.domain.ProfitCalculator;
import step3.domain.WinningNumbers;

public class GameView {
    private static final int LOTTO_TICKET_PRICE = 1000;
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        long money = inputView.inputMoney();
        int LottoTicketCount = (int)(money/LOTTO_TICKET_PRICE);
        resultView.printLottoTicketCount(LottoTicketCount);

        LottoTicket[] lottoTickets = new LottoTicket[LottoTicketCount];
        WinningType[] winningTypes = new WinningType[LottoTicketCount];

        String winningNumberText = inputView.inputWinningNumber();
        WinningNumbers winningNumbers = new WinningNumbers(winningNumberText);

        LottoTicketGenerator generator = new LottoTicketGenerator();
        for (int i=0; i<LottoTicketCount; i++) {
            LottoTicket lottoTicket = generator.generate();
            lottoTickets[i] = lottoTicket;
            System.out.println(lottoTickets[i]);
        }

        for (int i=0; i<LottoTicketCount; i++) {
            winningTypes[i] = winningNumbers.findWinningType(lottoTickets[i]);
        }

        ProfitCalculator profitCalculator = new ProfitCalculator();
        double profit = profitCalculator.calculate(money, winningTypes);

        resultView.printResultStatistics(winningTypes);
        resultView.printResultProfit(profit);

    }
}
