package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {
    private final InputView inputView;
    private final ResultView outputView;

    public LottoController(InputView inputView, ResultView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Lottos tickets = buyLotto();
        printResult(tickets);
    }

    private Lottos buyLotto() {
        int money = inputView.inputMoney();
        List<List<Integer>> ticketsNumbers = inputView.inputManualTickets();
        Lottos tickets = LottoSeller.issueLotto(money, ticketsNumbers);

        outputView.printCheckPurchaseMessage(ticketsNumbers.size(), tickets.count()-ticketsNumbers.size());
        outputView.printLottoTickets(tickets);
        return tickets;
    }

    private void printResult(Lottos tickets) {
        WinningNumber winningNumber = new WinningNumber(
                inputView.inputDefaultWinningNumbers(),
                inputView.inputBonusBallNumber());

        LottoReport report = new LottoReport(tickets, winningNumber);
        outputView.printResultReport(report);
    }
}
