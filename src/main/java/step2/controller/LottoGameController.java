package step2.controller;

import step2.domain.LottoGame;
import step2.domain.LottoGames;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoGameController {

    LottoGames lottoGames = new LottoGames();

    public void run() {

        int money = InputView.readInt("구매금액을 입력해 주세요");
        int gameCount = lottoGames.howManyBuyGames(money);
        ResultView.printMessage(gameCount + "개를 구매했습니다.");

        List<LottoGame> lottos = lottoGames.buyLottoGame(gameCount);
        ResultView.printList(lottos);
        LottoGame winningNumber = lottoGames.readWinningNumber(InputView.readString("지난 주 당첨 번호를 입력해 주세요"));

        ResultView.printBlankLine();
        ResultView.printMessage("당첨 통계");

        int[] lottoReport = new int[7];
        for (LottoGame lottoGame : lottos) {
            int rightCount = (int) winningNumber.howManyRight(lottoGame);
            lottoReport[rightCount]++;
        }

        ResultView.printResultReport(lottoReport);

    }

}
