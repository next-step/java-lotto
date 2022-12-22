package step3;

import step3.domain.*;
import step3.view.InputView;
import step3.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {

        int lottoCount = InputView.inputMoney();
        Lottos buyLottos = new Lottos(lottoCount);
        ResultView.printBuyLottos(buyLottos);

        Integer[] inputWinningLotto = InputView.inputWinningLotto();
        int bonusNumber = InputView.inputBonusNumber();


        WinningLotto winningLotto = new WinningLotto(inputWinningLotto, bonusNumber);

        LottoGame lottoGame = new LottoGame(buyLottos, winningLotto);

        LottoResult lottoResult = lottoGame.match();

        ResultView.printResult(lottoResult);
    }
}
