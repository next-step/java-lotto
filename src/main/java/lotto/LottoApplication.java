package lotto;

import lotto.controller.LottoController;
import lotto.model.*;

import lotto.view.OutputHandler;
import lotto.view.InputHandler;

import java.util.ArrayList;
import java.util.List;

public class LottoApplication {
    public static void main(String[] args){
        LottoController lottoController = new LottoController(CandidateLottoGenerator.generate());
        int totalExpense = InputHandler.askExpense();
        int totalNumLottoTicket = InputHandler.getAvailableNumLottoTicket(totalExpense);
        int numManualLottoTicket = InputHandler.askNumManualLottoTicket();
        int numAutoLottoTickets = totalNumLottoTicket - numManualLottoTicket;
        List<LottoTicket> manualLottoTickets = InputHandler.askManualLottoTickets(numManualLottoTicket);
        List<LottoTicket> autoLottoTickets = lottoController.generate(numAutoLottoTickets);
        List<LottoTicket> totalLottoTickets = new ArrayList<>();
        totalLottoTickets.addAll(manualLottoTickets);
        totalLottoTickets.addAll(autoLottoTickets);
        OutputHandler.printLotto(totalLottoTickets);
        List<LottoNumber> winningNumbers = InputHandler.askWinningNumbers();
        LottoNumber bonusNumber = InputHandler.askBonusNumber();
        LottoResult lottoResult = lottoController.run(new WinningLottoTicket(winningNumbers, bonusNumber),totalLottoTickets ,totalExpense);
        OutputHandler.printScoreMap(lottoResult);
        OutputHandler.printResult(lottoResult);

    }
}
