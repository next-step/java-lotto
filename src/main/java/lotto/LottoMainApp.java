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
        LottoTickets lottoTickets = lottoGame.createLottoTickets(buyingBudget);

        cui.printLottoTickets(lottoTickets);

        List<Integer> winLottoNumber = cui.inputWinLottoNumber();
        LottoResults lottoResults = lottoGame.analysisResult(lottoTickets, winLottoNumber);

        cui.print(lottoResults);
    }

}
