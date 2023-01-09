package lottoGame;

import lottoGame.domain.*;
import lottoGame.view.InputView;
import lottoGame.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        Money money =  new Money(InputView.inputMoney(), InputView.inputManualBuyCount());
        List<List<Integer>> manualLottos = InputView.inputManualLotto(money.getManualLottoCount());

        Lottos buyLottos = new Lottos(manualLottos, money.getAutoLottoCount());
        ResultView.printBuyCount(money);
        ResultView.printBuyLottos(buyLottos);

        List<Integer> inputWinningLotto = InputView.inputWinningLotto();
        LottoNumber bonusNumber = LottoNumber.of(InputView.inputBonusNumber(inputWinningLotto));

        WinningLotto winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
        LottoGame lottoGame = new LottoGame(buyLottos, winningLotto);
        LottoResult lottoResult = lottoGame.match();
        ResultView.printResult(lottoResult);
    }
}
