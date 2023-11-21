package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoController {

    public static void main(String[] args) {
        List<Lotto> lottoTickets = buyLotto();

        for (int i = 0; i < lottoTickets.size(); i++) {
            ResultView.printLottoTicket(lottoTickets.get(i));
        }

        String winningNumber = InputView.inputWinningNumbers();
        checkLottoResult(winningNumber, lottoTickets);
    }

    public static List<Lotto> buyLotto() {
        int money = InputView.inputMoney();
        List<Lotto> tickets = LottoMachine.issue(money);
        ResultView.printCheckPurchaseMessage(tickets.size());
        return tickets;
    }

    public static void checkLottoResult(String winningNumber, List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            ticket.matchNumbers(winningNumber);
        }
    }
}
