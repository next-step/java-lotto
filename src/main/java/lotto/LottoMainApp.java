package lotto;

import java.util.List;
import lotto.controller.LottoGameController;
import lotto.domain.LottoResults;
import lotto.domain.LottoTickets;
import lotto.view.CommandlineUserInterface;

public class LottoMainApp {

    public static void main(String[] args) {
        CommandlineUserInterface cui = new CommandlineUserInterface();
        LottoGameController lottoGame = new LottoGameController();

        int buyingBudget = cui.inputLottoBuyingBudget();
        int buyingManualCount = cui.inputLottoBuyingManual();
        List<List<Integer>> manualLottoNumbers = cui.inputManualLottoNumbers(buyingManualCount);

        LottoTickets lottoTickets = lottoGame.createLottoTicketsWithManual(buyingBudget, manualLottoNumbers);

        cui.printLottoTickets(lottoTickets, buyingManualCount);

        List<Integer> winLottoNumber = cui.inputWinLottoNumber();
        int bonusBallNumber = cui.inputBonusBallNumber();

        LottoResults lottoResults = lottoGame.analysisResult(lottoTickets, winLottoNumber, bonusBallNumber);

        cui.print(lottoResults);
    }

}
