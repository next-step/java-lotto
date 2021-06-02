package lotto;

import lotto.controller.LottoController;
import lotto.model.*;

import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args){

        int expense = ViewInput.askExpense();
        int numLottoTicket = ViewInput.askAvailableNumLottoTicket(expense);
        LottoController lottoController = new LottoController(CandidateLottoGenerator.generate());
        List<LottoTicket> userLottoTickets = lottoController.generate(numLottoTicket);
        ConsoleView.printLotto(userLottoTickets);

        List<LottoNumber> winningNumbers = ViewInput.askWinningNumbers();
        LottoNumber bonusNumber = ViewInput.askBonusNumber();
        LottoResult lottoResult = lottoController.run(new WinningLottoTicket(winningNumbers, bonusNumber),userLottoTickets ,expense);
        ConsoleView.printScoreMap(lottoResult);
        ConsoleView.printResult(lottoResult);

    }
}
