package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoGameResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoController {
    public static void main(String[] args) {
        int budget = InputView.getBudget();

        LottoGame lottoGame = new LottoGame();
        List<Lotto> lottos = lottoGame.makeLotto(budget);

        int lottoCount = lottoGame.getLottoCount(budget);
        ResultView.showLottoCount(lottoCount);

        for (Lotto lotto : lottos) {
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
