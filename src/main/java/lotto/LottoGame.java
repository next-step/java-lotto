package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        List<Lotto> lottos = LottoFactory.issueLottos(InputView.inputPurchaseAmount());

        LottoManager lottoManager = new LottoManager(lottos);

        ResultView.printLottos(lottoManager);

        WinningLotto winningLotto = new WinningLotto(InputView.inputWinningLotto());

        WinningResults winningResults = new WinningResults(lottoManager, winningLotto);

        ResultView.printResults(winningResults.getResults());

    }
}
