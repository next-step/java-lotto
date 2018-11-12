package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        int budget = InputView.getBudget();

        LottoGame lottoGame = new LottoGame();
        BundleLotto lottos = lottoGame.makeLotto(budget);

        int lottoCount = lottoGame.getLottoCount(budget);
        ResultView.showLottoCount(lottoCount);

        for (Lotto lotto : lottos.getLottos()) {
            ResultView.showLottoNumbers(lotto);
        }

        WinningLotto winningLotto = InputView.getWinningNumber();
        int bonusBall = InputView.getBonusBall();

        LottoGameResult lottoGameResult = new LottoGameResult();
        lottoGameResult.doCalculateLottoResult(lottos, winningLotto, bonusBall);

        ResultView.showResult(lottoGameResult);

        String ratio = lottoGameResult.getRatio(lottoGameResult.getLottoDtos(), budget);
        ResultView.showRatioResult(ratio);
    }
}
