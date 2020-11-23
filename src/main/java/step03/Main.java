package step03;

import step03.domain.*;
import step03.view.InputView;
import step03.view.ResultView;


public class Main {
    public static void main(String[] args) {
        int payment = InputView.payLotto();
        Lottos userLottos = LottoSeller.generateLottos(payment);

        ResultView.showLottoCount(userLottos.size());
        ResultView.showLottos(userLottos.getLottos());

        Lotto winningLotto = LottoNumberTokenizer.execute(InputView.createWinningNumber());
        LottoBall bonusBall = LottoBall.valueOf(InputView.pickBonusBall());
        WinningComposer winningComposer = WinningComposer.of(winningLotto, bonusBall);

        RankCounter rankCounter = winningComposer.calculateMatchOfCount(userLottos);
        ResultView.showWinningTable(rankCounter);
        ResultView.showYield( rankCounter.calculateGainRate());
    }
}
