package rankingtwolotto.controller;

import rankingtwolotto.domain.Lotto;
import rankingtwolotto.domain.LottoNumber;
import rankingtwolotto.domain.LottoWinning;
import rankingtwolotto.domain.Lottos;
import rankingtwolotto.view.InputView;
import rankingtwolotto.view.OutputView;

import java.util.List;

import static rankingtwolotto.domain.Lottos.createLottos;
import static rankingtwolotto.view.InputView.enterBonusBallNumber;
import static rankingtwolotto.view.InputView.winningNumber;
import static rankingtwolotto.view.OutputView.announcementWiningResult;
import static rankingtwolotto.view.OutputView.showPurchaseLottos;

public class RankingTwoController {
    public void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int purchaseLottoNum = OutputView.purchaseLottoNum(purchaseAmount);
        Lottos purchaseLottos = createLottos(purchaseLottoNum);
        for (Lotto lotto : purchaseLottos.getLottos()){
            showPurchaseLottos(lotto);
        }
        Lotto winningLottoNumber = winningNumber();
        LottoNumber bonusBallNumber = enterBonusBallNumber();
        List<Integer> matchedLottoCnt = LottoWinning.LottoResult(winningLottoNumber, purchaseLottos, bonusBallNumber);
        announcementWiningResult(purchaseAmount, matchedLottoCnt);
    }
}
