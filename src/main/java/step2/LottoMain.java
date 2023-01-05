package step2;

import step2.domain.*;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int money = InputView.inputMoney();
        int manualBuyCount = InputView.inputManualBuyCount(money);
        List<List<Integer>> manualLottos = InputView.inputManualLotto(manualBuyCount);
        int autoBuyCount = money / 1000 - manualBuyCount;

        Lottos buyLottos = new Lottos(manualLottos, autoBuyCount);
        ResultView.printBuyCount(manualBuyCount, autoBuyCount);
        ResultView.printBuyLottos(buyLottos);

        List<Integer> inputWinningLotto = InputView.inputWinningLotto();
        int bonusNumber = InputView.inputBonusNumber(inputWinningLotto);

        WinningLotto winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
        LottoGame lottoGame = new LottoGame(buyLottos, winningLotto);
        LottoResult lottoResult = lottoGame.match();
        ResultView.printResult(lottoResult);
    }
}
