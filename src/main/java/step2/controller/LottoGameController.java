package step2.controller;

import step2.domain.LottoTicket;
import step2.domain.LottoGames;
import step2.domain.LottoResultReport;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGameController {

    private LottoGames lottoGames = new LottoGames();

    public void playLottoGame() {

        int money = InputView.readAmountOfPurchase();
        int gameCount = lottoGames.calculateBuyingTicketCount(money);
        ResultView.printMessage(gameCount + "개를 구매했습니다.");
        if (gameCount == 0) {
            return;
        }

        List<LottoTicket> lottos = lottoGames.buyLottoGame(gameCount);
        ResultView.printList(lottos);
        LottoTicket winningNumber = lottoGames.readWinningNumber(InputView.readWinningNumbers());

        ResultView.printBlankLine();
        ResultView.printMessage("당첨 통계");

        LottoResultReport lottoResultReport = new LottoResultReport();
        for (LottoTicket lottoTicket : lottos) {
            int matchCount = (int) winningNumber.countMatchingNumbers(lottoTicket);
            lottoResultReport.recordRank(matchCount);
        }

        ResultView.printResultReport(lottoResultReport);
        double profit = lottoResultReport.calculateProfit(gameCount);
        ResultView.printMessage("총 수익률은 " + profit + "입니다.");

    }

}
