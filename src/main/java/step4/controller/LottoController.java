package step4.controller;

import step4.domain.lotto.LottoTicketMachine;
import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.domain.lotto.firstcollection.LottoTickets;
import step4.domain.lotto.firstcollection.WinningResults;
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
        LottoPurchaseInfoDTO infoDTO = inputView.getPurchaseInfo();

        LottoTickets tickets = LottoTicketMachine.ticketing(infoDTO);
        resultView.drawTicket(tickets);

        WinningNumbers winningNumber = inputView.getWinningNumbers();
        WinningResults winningResults = winningNumber.getWinningStatistics(tickets);

        resultView.drawWinningStatistics(winningResults);
        resultView.drawRevenueRate(tickets, winningResults);
    }
}
