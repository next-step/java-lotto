package step2.controller;

import step2.domain.lotto.LottoTicketMachine;
import step2.domain.lotto.LottoTickets;
import step2.domain.lotto.WinningNumber;
import step2.strategy.LottoNumberMakeStrategy;
import step2.view.InputView;
import step2.view.LottoInputView;
import step2.view.LottoResultView;
import step2.view.ResultView;

import java.util.Scanner;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoTicketMachine lottoTicketMachine;

    public LottoController() {
        this(new LottoInputView(), new LottoResultView(), new LottoTicketMachine());
    }

    public LottoController(InputView inputView, ResultView resultView, LottoTicketMachine lottoTicketMachine) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoTicketMachine = lottoTicketMachine;
    }

    public void ticketing() {
        Scanner scanner = new Scanner(System.in);
        int useAmount = inputView.getUseAmount(scanner);
        LottoTickets tickets = lottoTicketMachine.ticketing(useAmount, new LottoNumberMakeStrategy());

        resultView.drawTicket(tickets);

        WinningNumber winningNumber = inputView.getWinningNumber(scanner);
        resultView.drawWinningStatistics(tickets, winningNumber);
        resultView.drawRevenueRate(tickets, winningNumber);
    }
}
