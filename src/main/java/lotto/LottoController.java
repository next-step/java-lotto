package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoController {
    public static void main(String[] args) {
        LottoCountManager lottoCountManager = InputView.getBudget();

        BundleLotto lottos = InputView.getManualLottoNumbers(lottoCountManager);

        LottoGame lottoGame = new LottoGame();
        lottos = lottoGame.makeLotto(lottoCountManager, lottos);

        ResultView.showLottoCount(lottoCountManager);
        ResultView.showLottoNumbers(lottos);

        WinningLotto winningLotto = InputView.getWinningNumberWithBonus();

        LottoGameResult lottoGameResult = new LottoGameResult();
        lottoGameResult.doCalculateLottoResult(lottos, winningLotto);

        ResultView.showResult(lottoGameResult);

        String ratio = lottoGameResult.getRatio(lottoGameResult.getLottoDtos(), lottoCountManager);
        ResultView.showRatioResult(ratio);
    }
}
