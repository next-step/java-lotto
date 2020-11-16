package step4.controller;

import step4.lotto.LottoTicketMachine;
import step4.lotto.WinningNumbers;
import step4.lotto.firstcollection.LottoTickets;
import step4.lotto.firstcollection.WinningResults;
import step4.strategy.LottoNumberMakeStrategy;
import step4.view.InputView;
import step4.view.LottoInputView;
import step4.view.LottoResultView;
import step4.view.ResultView;

import java.util.Scanner;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this(new LottoInputView(new Scanner(System.in)), new LottoResultView());
    }

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void ticketing() {
        int useAmount = inputView.getUseAmount();
        LottoTickets tickets = LottoTicketMachine.ticketing(useAmount, new LottoNumberMakeStrategy());

        resultView.drawTicket(tickets);

        WinningNumbers winningNumbers = inputView.getWinningNumber();
        WinningResults winningResults = winningNumbers.getWinningStatistics(tickets);
        double revenueRate = winningNumbers.getRevenueRate(tickets);

        resultView.drawWinningStatistics(winningResults);
        resultView.drawRevenueRate(revenueRate, winningNumbers.isRevenue(revenueRate));
    }
}
