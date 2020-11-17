package step4.controller;

import step4.domain.lotto.LottoTicketMachine;
import step4.domain.lotto.WinningNumbers;
import step4.domain.lotto.dto.LottoPurchaseInfoDTO;
import step4.domain.lotto.firstcollection.LottoTickets;
import step4.domain.lotto.firstcollection.WinningResults;
import step4.strategy.LottoNumberMakeStrategy;
import step4.view.InputView;
import step4.view.LottoInputView;
import step4.view.LottoResultView;
import step4.view.ResultView;

import java.util.List;
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

        int manualSize = inputView.getManualTicketSize();
        List<String> manualNumbers = inputView.getManualNumbers(manualSize);

        LottoPurchaseInfoDTO infoDTO = new LottoPurchaseInfoDTO.Builder(useAmount)
                .inputManualNumbers(manualNumbers)
                .manualSize(manualSize)
                .build();

        LottoTickets tickets = LottoTicketMachine.ticketing(infoDTO, new LottoNumberMakeStrategy());
        resultView.drawTicket(tickets);

        WinningNumbers winningNumber = inputView.getWinningNumber();
        WinningResults winningResults = winningNumber.getWinningStatistics(tickets);
        double revenueRate = winningResults.getRevenue(tickets.countTickets());

        resultView.drawWinningStatistics(winningResults);
        resultView.drawRevenueRate(revenueRate, winningResults.isRevenue(revenueRate));
    }
}
