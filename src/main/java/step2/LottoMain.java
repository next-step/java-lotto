package step2;

import step2.domain.Lotto;
import step2.domain.Lottos;
import step2.domain.WinningLotto;
import step2.view.InputView;
import step2.view.ResultView;

public class LottoMain {

    public static void main(String[] args) {

        int lottoCount = InputView.inputMoney();
        Lottos buyLottos = new Lottos(lottoCount);
        ResultView.printBuyLottos(buyLottos);

        Integer[] inputWinningLotto = InputView.inputWinningLotto();
        Lotto winLotto = new Lotto(inputWinningLotto);

        WinningLotto winningLotto = new WinningLotto(buyLottos, winLotto);
        winningLotto.match();

        ResultView.printResult(winningLotto);
    }
}
