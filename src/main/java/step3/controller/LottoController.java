package step3.controller;

import step3.domain.lotto.LottoTicketMachine;
import step3.domain.lotto.LottoTickets;
import step3.domain.lotto.WinningNumbers;
import step3.strategy.LottoNumberMakeStrategy;
import step3.view.InputView;
import step3.view.LottoInputView;
import step3.view.LottoResultView;
import step3.view.ResultView;

import java.util.Scanner;

public class LottoController {
    private final InputView inputView;
    private final ResultView resultView;

    public LottoController() {
        this(new LottoInputView(), new LottoResultView());
    }

    public LottoController(InputView inputView, ResultView resultView) {
        this.inputView = inputView;
        this.resultView = resultView;
    }

    public void ticketing() {
        Scanner scanner = new Scanner(System.in);
        int useAmount = inputView.getUseAmount(scanner);
        LottoTickets tickets = LottoTicketMachine.ticketing(useAmount, new LottoNumberMakeStrategy());

        resultView.drawTicket(tickets);

        WinningNumbers winningNumbers = inputView.getWinningNumber(scanner);
        resultView.drawWinningStatistics(tickets, winningNumbers);
        resultView.drawRevenueRate(tickets, winningNumbers);
    }
}
