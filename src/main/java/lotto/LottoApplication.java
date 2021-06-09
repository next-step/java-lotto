package lotto;

import lotto.controller.LottoController;
import lotto.model.*;

import lotto.view.ConsoleView;
import lotto.view.ViewInput;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args){
        LottoController lottoController = new LottoController(CandidateLottoGenerator.generate());
        int totalExpense = ViewInput.askExpense();
        int totalNumLottoTicket = ViewInput.getAvailableNumLottoTicket(totalExpense);
        int numManualLottoTicket = ViewInput.askNumManualLottoTicket();
        int numAutoLottoTickets = totalNumLottoTicket - numManualLottoTicket;
        List<LottoTicket> manualLottoTickets = ViewInput.askManualLottoTickets(numManualLottoTicket);
        List<LottoTicket> autoLottoTickets = lottoController.generate(numAutoLottoTickets);
        List<LottoTicket> totalLottoTickets = new ArrayList<>();
        totalLottoTickets.addAll(manualLottoTickets);
        totalLottoTickets.addAll(autoLottoTickets);

        ConsoleView.printLotto(totalLottoTickets);

        List<LottoNumber> winningNumbers = ViewInput.askWinningNumbers();
        LottoNumber bonusNumber = ViewInput.askBonusNumber();
        LottoResult lottoResult = lottoController.run(new WinningLottoTicket(winningNumbers, bonusNumber),totalLottoTickets ,totalExpense);
        ConsoleView.printScoreMap(lottoResult);
        ConsoleView.printResult(lottoResult);

    }
}
