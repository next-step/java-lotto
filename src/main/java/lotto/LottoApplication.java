package lotto;

import lotto.controller.LottoController;
import lotto.model.LottoNumber;
import lotto.model.LottoResult;

import lotto.model.LottoTicket;
import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args){

        int expense = ViewInput.getExpense();
        int numLottoTicket = ViewInput.getAvailableNumLottoTicket(expense);
        LottoController lottoController = new LottoController();
        List<LottoTicket> userLottoTickets = lottoController.generate(numLottoTicket);
        ConsoleView.printLotto(userLottoTickets);

        List<LottoNumber> winningNumbers = ViewInput.getWinningNumbers();
        LottoResult lottoResult = lottoController.run(new LottoTicket(winningNumbers),userLottoTickets ,expense);
        ConsoleView.printScoreMap(lottoResult);
        ConsoleView.printResult(lottoResult);

    }
}
