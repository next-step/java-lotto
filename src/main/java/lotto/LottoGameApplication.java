package lotto;

import lotto.domain.LottoCount;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoOutView;

import java.util.List;

public class LottoGameApplication {
    public static void main(String[] args) {
        LottoCount lottoCount = LottoInputView.getLottoCount();
        LottoGame lottoGame = new LottoGame(lottoCount);
        lottoGame.start();
        
        LottoResult lottoResult = lottoGame.getLottoResult();
        LottoOutView.show(lottoResult.getLottosView());

        WinningLotto winningLotto = LottoInputView.getWinningLotto();
        List<Integer> matchCounts = lottoGame.match(winningLotto);
        LottoOutView.showStatistic(lottoResult.getStatisticsView(matchCounts));
    }
}
