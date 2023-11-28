package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        List<List<Integer>> ticketsNumbers = InputView.inputManualTickets();
        Lottos tickets = LottoSeller.issueLotto(money, ticketsNumbers);

        ResultView.printCheckPurchaseMessage(ticketsNumbers.size(), tickets.count()-ticketsNumbers.size());
        ResultView.printLottoTickets(tickets);

        WinningNumber winningNumber = new WinningNumber(
                InputView.inputDefaultWinningNumbers(),
                InputView.inputBonusBallNumber());

        LottoReport report = new LottoReport(tickets, winningNumber);
        ResultView.printResultReport(report);
    }
}
