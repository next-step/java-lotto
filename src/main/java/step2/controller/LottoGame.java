package step2.controller;

import step2.domain.Lottos;
import step2.domain.MatchesResult;
import step2.domain.WinnersNo;
import step2.ui.InputView;
import step2.ui.ResultView;

import static step2.domain.Lottos.ofLottoGames;
import static step2.domain.WinnersNo.ofWinnersNo;

public class LottoGame {
    public static void main(String[] args) {
        InputView.startMsg();

        int moneyInput = InputView.moneyInput();
        Lottos lottos = ofLottoGames(moneyInput);

        ResultView.printMyGame(lottos);

        String input = InputView.getPreviousNumber();
        int bonusNumber = InputView.getBonusNumber();


        WinnersNo winnersNo = ofWinnersNo(bonusNumber, input);
        MatchesResult matchesResult = MatchesResult.ofMatchesResults(winnersNo, lottos);

        ResultView.outputOfWinningResults(matchesResult, moneyInput);
    }
}
