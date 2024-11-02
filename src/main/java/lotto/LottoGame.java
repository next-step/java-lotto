package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoGame {

    public static void main(String[] args) {
        List<Lotto> lottos = lottoStore.issueLottos(InputView.inputPurchaseAmount());

        Lottos lottoManager = new Lottos(lottos);

        ResultView.printLottos(lottoManager);

        Lotto winningLotto = new Lotto(InputView.inputWinningLotto());

        WinningResults winningResults = new WinningResults(lottoManager, winningLotto);

        ResultView.printResults(winningResults.getResults(), lottoManager.purchaseAmount());

    }
}
