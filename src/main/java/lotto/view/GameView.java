package lotto.view;

import lotto.common.WinningType;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTicketGenerator;
import lotto.domain.Money;
import lotto.domain.WinningNumbers;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = new Money(inputView.inputMoney());
        int lottoTicketCount = money.countLottoTicket();
        resultView.printLottoTicketCount(money.countLottoTicket());

        LottoTicket[] lottoTickets = generateLottoTickets(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets);

        WinningType[] winningTypes = generateWinningTypes(lottoTickets);
        resultView.printResultStatistics(winningTypes);
        resultView.printResultProfit(money.calculateProfit(winningTypes));

        inputView.close();
    }

    private LottoTicket[] generateLottoTickets(int lottoTicketCount) {
        LottoTicket[] lottoTickets = new LottoTicket[lottoTicketCount];
        LottoTicketGenerator generator = new LottoTicketGenerator();
        for (int i = 0; i < lottoTicketCount; i++) {
            LottoTicket lottoTicket = generator.generate();
            lottoTickets[i] = lottoTicket;
        }
        
        return lottoTickets;
    }

    private WinningType[] generateWinningTypes(LottoTicket[] lottoTickets) {
        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputWinningNumber());
        WinningType[] winningTypes = new WinningType[lottoTickets.length];
        for (int i = 0; i < lottoTickets.length; i++) {
            winningTypes[i] = winningNumbers.findWinningType(lottoTickets[i]);
        }

        return winningTypes;
    }
}
