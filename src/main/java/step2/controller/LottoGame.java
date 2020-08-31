package step2.controller;

import step2.domain.Lottos;
import step2.domain.MatchesResult;
import step2.domain.WinnersNo;
import step2.ui.InputView;
import step2.ui.ResultView;

import static step2.domain.Lottos.ofAutoAndManualLottoGames;
import static step2.domain.Lottos.ofAutoLottoGames;
import static step2.domain.LottosGenerator.getAutoLottos;
import static step2.domain.LottosGenerator.getManualLottos;
import static step2.domain.WinnersNo.ofWinnersNo;
import static step2.ui.InputView.getManualGame;

public class LottoGame {
    public static void main(String[] args) {

        int totalAutoGameCount = InputView.getPurchaseAmount();
        int totalManualGameCount = InputView.getTotalManualGameCount();

        Lottos lottos = totalManualGameCount > 0
            ? ofAutoAndManualLottoGames(getAutoLottos(totalAutoGameCount), getManualLottos(getManualGame(totalManualGameCount)))
            : ofAutoLottoGames(getAutoLottos(totalAutoGameCount));

        ResultView.printMyGameList(totalManualGameCount, totalAutoGameCount);
        ResultView.printMyGame(lottos);

        String previousNumber = InputView.getPreviousNumber();
        int bonusNumber = InputView.getBonusNumber();

        WinnersNo winnersNo = ofWinnersNo(bonusNumber, previousNumber);
        MatchesResult matchesResult = MatchesResult.ofMatchesResults(winnersNo, lottos);

        ResultView.outputOfWinningResults(matchesResult, totalAutoGameCount);
    }
}
