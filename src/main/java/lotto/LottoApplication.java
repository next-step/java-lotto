package lotto;

import lotto.controller.LottoController;
import lotto.model.*;

import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.List;

public class LottoApplication {
    public static void main(String[] args){

        int totalExpense = ViewInput.askExpense();
        int totalNumLottoTicket = ViewInput.getAvailableNumLottoTicket(totalExpense);
        int numManualLottoTicket = ViewInput.askNumManualLottoTicket();
        int numAutoLottoTickets = totalNumLottoTicket - numManualLottoTicket;
        LottoController lottoController = new LottoController(CandidateLottoGenerator.generate());
        List<LottoTicket> userLottoTickets = lottoController.generate(numAutoLottoTickets);
        ConsoleView.printLotto(userLottoTickets);

        List<LottoNumber> winningNumbers = ViewInput.askWinningNumbers();
        LottoNumber bonusNumber = ViewInput.askBonusNumber();
        LottoResult lottoResult = lottoController.run(new WinningLottoTicket(winningNumbers, bonusNumber),userLottoTickets ,totalExpense);
        ConsoleView.printScoreMap(lottoResult);
        ConsoleView.printResult(lottoResult);

    }
}
