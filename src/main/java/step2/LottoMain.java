package step2;

import step2.domain.LottoGame;
import step2.domain.LottoResult;
import step2.domain.Lottos;
import step2.domain.WinningLotto;
import step2.view.InputView;
import step2.view.ResultView;

import java.util.List;

public class LottoMain {

    public static void main(String[] args) {
        int lottoCount = InputView.inputMoney();
        Lottos buyLottos = new Lottos(lottoCount);
        ResultView.printBuyLottos(buyLottos);

        List<Integer> inputWinningLotto = InputView.inputWinningLotto();
        int bonusNumber = InputView.inputBonusNumber();

        WinningLotto winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);
        LottoGame lottoGame = new LottoGame(buyLottos, winningLotto);
        LottoResult lottoResult = lottoGame.match();
        ResultView.printResult(lottoResult);
    }
}
