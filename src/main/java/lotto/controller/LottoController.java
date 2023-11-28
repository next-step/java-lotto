package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void main(String[] args) {
        Lottos tickets = LottoSeller.issueLotto(InputView.inputMoney());

        ResultView.printCheckPurchaseMessage(tickets.count());
        ResultView.printLottoTickets(tickets);

        WinningNumber winningNumber = new WinningNumber(
                InputView.inputDefaultWinningNumbers(),
                InputView.inputBonusBallNumber());

        LottoReport report = new LottoReport(
                tickets.tickets()
                        .stream()
                        .map(ticket -> winningNumber.match(ticket))
                        .collect(Collectors.toList()));
        ResultView.printResultReport(report);
    }
}
