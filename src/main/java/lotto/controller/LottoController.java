package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {

    public static void main(String[] args) {
        List<Lotto> lottoTickets = buyLotto();

        for (int i = 0; i < lottoTickets.size(); i++) {
            ResultView.printLottoTicket(lottoTickets.get(i));
        }

        String winningNumber = InputView.inputWinningNumbers();
    }

    public static List<Lotto> buyLotto() {
        int money = InputView.inputMoney();
        List<Lotto> tickets = LottoMachine.issue(money);
        ResultView.printCheckPurchaseMessage(tickets.size());
        return tickets;
    }
}
