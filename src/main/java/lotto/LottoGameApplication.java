package lotto;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoCount lottoCount = LottoInputView.getLottoCount();
        LottoGame lottoGame = new LottoGame();
        lottoGame.start(lottoCount);

        LottoResult lottoResult = lottoGame.getLottoResult();
        LottoOutView.show(lottoResult.getLottosView());

        WinningLotto winningLotto = LottoInputView.getWinningLotto();
        List<MatchResult> matchCounts = lottoGame.match(winningLotto);
        LottoOutView.showStatistic(lottoResult.getStatisticsView(matchCounts));
    }
}
