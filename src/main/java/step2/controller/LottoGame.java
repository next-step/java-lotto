package step2.controller;

import step2.domain.Lotto;
import step2.domain.MatchesResult;
import step2.domain.WinnersNo;
import step2.ui.InputView;
import step2.ui.ResultView;

import java.util.List;

import static step2.domain.Lotto.ofLottoGames;
import static step2.domain.WinnerVerification.getWinnerVerified;
import static step2.domain.WinnersNo.ofWinnersNo;
import static step2.ui.InputView.enterThePreviousNumberMsg;

public class LottoGame {
    public static void main(String[] args) {
        InputView.startMsg();

        int moneyInput = InputView.moneyInput();
        List<Lotto> lottos = ofLottoGames(moneyInput);

        ResultView.printMyGame(lottos);
        enterThePreviousNumberMsg();

        WinnersNo winnersNo = ofWinnersNo(InputView.getPreviousNumber());
        MatchesResult matchesResult = MatchesResult.ofMatchesResults(getWinnerVerified(winnersNo, lottos));

        ResultView.outputOfWinningResults(matchesResult, moneyInput);
    }
}
