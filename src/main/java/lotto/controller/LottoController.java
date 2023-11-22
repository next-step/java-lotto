package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoReport;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        buyLottoAndCheckResult();
    }

    public static void buyLottoAndCheckResult() {
        List<Lotto> lottoTickets = buyLotto();

        for (Lotto lottoTicket : lottoTickets) {
            ResultView.printLottoTicket(lottoTicket);
        }

        checkLottoResult(lottoTickets);
    }

    private static List<Lotto> buyLotto() {
        int money = InputView.inputMoney();
        List<Lotto> tickets = LottoMachine.issue(money);
        ResultView.printCheckPurchaseMessage(tickets.size());
        return tickets;
    }

    private static void checkLottoResult(List<Lotto> tickets) {
        String winningNumber = InputView.inputWinningNumbers();
        LottoReport report = new LottoReport(winningNumber, tickets);
        ResultView.printResultReport(report);
    }
}
