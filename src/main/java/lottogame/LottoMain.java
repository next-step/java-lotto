package lottogame;

import java.util.List;
import lottogame.domain.Lotto;
import lottogame.domain.LottoFactory;
import lottogame.domain.LottoGame;
import lottogame.domain.Rank;
import lottogame.view.InputView;
import lottogame.view.ResultView;
import utils.numbergenerator.RandomNumberGenerator;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.requestMoney();
        LottoGame lottoGame = new LottoGame(new LottoFactory(new RandomNumberGenerator()));
        List<Lotto> lottos = lottoGame.createLottos(money);
        ResultView.printCountOfPurchaseLottos(lottos);
        ResultView.printLottos(lottos);

        Lotto winningLotto = lottoGame.createLotto(InputView.requestWinningLotto());

        ResultView.printWinningResult(lottoGame.checkRanks(winningLotto, lottos));
        ResultView.printReturnOfRate(lottoGame.calculateReturnOfRate(winningLotto, lottos));
    }
}
