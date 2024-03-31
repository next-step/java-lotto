package lottogame;

import java.util.List;
import lottogame.domain.Lottos;
import lottogame.domain.LottoGame;
import lottogame.domain.Money;
import lottogame.domain.Number;
import lottogame.domain.WinningLottos;
import lottogame.view.InputView;
import lottogame.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {
        Money money = InputView.requestMoney();
        ResultView.printLinkBreak();
        LottoGame lottoGame = new LottoGame();
        Number countOfLottos = lottoGame.calculateCountOfLottos(money);
        Number manualCountOfLotto = InputView.requestCountOfManualLottos(countOfLottos);
        ResultView.printLinkBreak();
        List<List<Integer>> manualInputNumbers = InputView.requestMultipleManualLottos(manualCountOfLotto);
        List<Lottos> multipleManualLottos = lottoGame.createMultipleLottos(manualInputNumbers);
        List<Lottos> multipleAutoLottos = lottoGame.createMultipleLottos(countOfLottos.minus(manualCountOfLotto));

        List<Lottos> lottos = lottoGame.merge(multipleManualLottos, multipleAutoLottos);
        ResultView.printAutoAndManualLottosCount(multipleManualLottos, multipleAutoLottos);
        ResultView.printLottos(lottos);

        List<Integer> winningLottosNumbers = InputView.requestWinningLotto();
        Number bonusNumber = InputView.requestBonusNumber();
        WinningLottos winningLotto = lottoGame.createWinningLotto(winningLottosNumbers, bonusNumber);

        ResultView.printWinningResult(lottoGame.checkRanks(winningLotto, lottos));
        ResultView.printReturnOfRate(lottoGame.calculateReturnOfRate(winningLotto, lottos));
    }
}
