package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoResult;

import lotto.model.LottoTicket;
import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args){
        ConsoleView consoleView = new ConsoleView();
        int expense = ViewInput.getExpense();
        int numLottoTicket = ViewInput.getAvailableNumLottoTicket(expense);
        LottoController lottoController = new LottoController(expense, numLottoTicket);
        List<LottoTicket> userLottoTickets = lottoController.generate();

        consoleView.printLotto(userLottoTickets);

        LottoResult lottoResult = lottoController.run(userLottoTickets);
        consoleView.print(lottoResult);

    }
}
