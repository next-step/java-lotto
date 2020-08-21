package step2.controller;

import step2.domain.Lotto;
import step2.domain.WinnersNo;
import step2.ui.InputView;
import step2.ui.ResultView;

import java.util.ArrayList;
import java.util.List;

import static step2.domain.Lotto.ofLotto;
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
        ResultView.outputOfWinningResults(getWinnerVerified(winnersNo, lottos), moneyInput);

    }

    public static List<Lotto> ofLottoGames(int games) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < games; i++) {
            lottos.add(ofLotto());
        }
        return lottos;
    }
}
