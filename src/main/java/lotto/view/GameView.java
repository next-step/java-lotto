package lotto.view;

import lotto.common.WinningType;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class GameView {
    InputView inputView = new InputView();
    ResultView resultView = new ResultView();

    public void start() {
        Money money = new Money(inputView.inputMoney());
        int lottoTicketCount = money.countLottoTicket();
        resultView.printLottoTicketCount(money.countLottoTicket());

        List<LottoTicket> lottoTickets = generateLottoTickets(lottoTicketCount);
        resultView.printLottoTickets(lottoTickets);

        WinningType[] winningTypes = generateWinningTypes(lottoTickets);
        resultView.printResultStatistics(winningTypes);
        resultView.printResultProfit(money.calculateProfit(winningTypes));

        inputView.close();
    }

    private List<LottoTicket> generateLottoTickets(int lottoTicketCount) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottoTickets.add(new LottoTicketGenerator().generate());
        }

        return lottoTickets;
    }

    private WinningType[] generateWinningTypes(List<LottoTicket> lottoTickets) {
        WinningNumbers winningNumbers = new WinningNumbers(inputView.inputWinningNumber());
        WinningType[] winningTypes = new WinningType[lottoTickets.size()];
        for (int i = 0; i < lottoTickets.size(); i++) {
            winningTypes[i] = winningNumbers.findWinningType(lottoTickets.get(i));
        }

        return winningTypes;
    }
}
