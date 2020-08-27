package step2.controller;

import step2.domain.Lottos;
import step2.domain.MatchesResult;
import step2.domain.WinnersNo;
import step2.ui.InputView;
import step2.ui.ResultView;

import static step2.domain.Lottos.ofAutoAndManualLottoGames;
import static step2.domain.Lottos.ofAutoLottoGames;
import static step2.domain.WinnersNo.ofWinnersNo;

public class LottoGame {
    public static void main(String[] args) {

        int totalAutoGameCount = InputView.getPurchaseAmount();
        int totalManualGameCount = InputView.getTotalManualGameCount();

        Lottos lottos = totalManualGameCount > 0
            ? ofAutoAndManualLottoGames(totalAutoGameCount, InputView.getManualGame(totalManualGameCount))
            : ofAutoLottoGames(totalAutoGameCount);

        ResultView.printMyGameList(totalManualGameCount, totalAutoGameCount);
        ResultView.printMyGame(lottos);

        String previousNumber = InputView.getPreviousNumber();
        int bonusNumber = InputView.getBonusNumber();

        WinnersNo winnersNo = ofWinnersNo(bonusNumber, previousNumber);
        MatchesResult matchesResult = MatchesResult.ofMatchesResults(winnersNo, lottos);

        ResultView.outputOfWinningResults(matchesResult, totalAutoGameCount);
    }
}
