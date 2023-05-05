package step2.controller;

import step2.domain.LottoGame;
import step2.domain.LottoGames;
import step2.domain.LottoResultReport;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGameController {

    LottoGames lottoGames = new LottoGames();

    public void run() {

        int money = InputView.readInt("구매금액을 입력해 주세요");
        int gameCount = lottoGames.howManyBuyGames(money);
        ResultView.printMessage(gameCount + "개를 구매했습니다.");
        if (gameCount == 0) {
            return;
        }

        List<LottoGame> lottos = lottoGames.buyLottoGame(gameCount);
        ResultView.printList(lottos);
        LottoGame winningNumber = lottoGames.readWinningNumber(InputView.readString("지난 주 당첨 번호를 입력해 주세요"));

        ResultView.printBlankLine();
        ResultView.printMessage("당첨 통계");

        LottoResultReport lottoResultReport = new LottoResultReport();
        for (LottoGame lottoGame : lottos) {
            int matchCount = (int) winningNumber.howManyRight(lottoGame);
            lottoResultReport.recordRank(matchCount);
        }

        ResultView.printResultReport(lottoResultReport);
        double profit = lottoResultReport.calculateProfit(gameCount);
        ResultView.printMessage("총 수익률은 " + profit + "입니다.");

    }

}
