package lotto.domain;

import lotto.exception.TicketNumberOutOfBoundException;
import lotto.exception.TicketPriceOutOfBoundException;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGameService {
    private LottoTickets lottoTickets;
    private WinningNumber winningNumbers;

    public LottoGameService() {
    }

    private LottoGameService(LottoTickets lottoTickets, WinningNumber winningNumbers) {
        this.lottoTickets = lottoTickets;
        this.winningNumbers = winningNumbers;
    }

    public static LottoGameService of(LottoTickets lottoTickets, WinningNumber winningNumbers) {
        return new LottoGameService(lottoTickets, winningNumbers);
    }

    public static LottoGameService from() {
        return new LottoGameService();
    }

    public void buyTickets() throws TicketNumberOutOfBoundException, TicketPriceOutOfBoundException {
        long money = InputView.inputMoney();
        List<Ticket> manualTickets = InputView.inputManualTickets();
        lottoTickets = LottoTickets.buyTickets(money, manualTickets);
        ResultView.printTickets(lottoTickets);
    }

    public void inputWinningNumber() throws TicketNumberOutOfBoundException {
        winningNumbers = InputView.inputWinningNumber();
    }

    public void makeLotteryResult() {
        ResultView.printWinningStatus(lottoTickets.winningStatus(winningNumbers));
        ResultView.printReturnRate(lottoTickets.returnRate(winningNumbers));
    }
}
