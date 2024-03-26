package lottogame;

import java.util.List;
import lottogame.domain.Lottos;
import lottogame.domain.LottoFactory;
import lottogame.domain.LottoGame;
import lottogame.domain.Number;
import lottogame.view.InputView;
import lottogame.view.ResultView;
import utils.numbergenerator.RandomNumberGenerator;

public class LottoMain {

    public static void main(String[] args) {
        Number money = InputView.requestMoney();
        LottoGame lottoGame = new LottoGame(new LottoFactory(new RandomNumberGenerator()));
        List<Lottos> lottos = lottoGame.createLottos(money);
        ResultView.printCountOfPurchaseLottos(lottos);
        ResultView.printLottos(lottos);

        Lottos winningLotto = lottoGame.createLotto(InputView.requestWinningLotto());

        ResultView.printWinningResult(lottoGame.checkRanks(winningLotto, lottos));
        ResultView.printReturnOfRate(lottoGame.calculateReturnOfRate(winningLotto, lottos));
    }
}
