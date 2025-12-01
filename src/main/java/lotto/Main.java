package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {
    public static void main(String[] args) {
        long price = InputView.initLottoPrice();
        LottoGame lottoGame = new LottoGame(price);
        ResultView.printLottos(lottoGame.lottos());

        Lotto winningLotto = new Lotto(InputView.initWinningLotto());
        LottoResult result = lottoGame.check(winningLotto);
        ResultView.printResult(result, lottoGame);

    }
}
