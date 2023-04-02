package automaticlotto.controller;

import automaticlotto.domain.Lotto;
import automaticlotto.domain.LottoWinning;
import automaticlotto.domain.Lottos;
import automaticlotto.view.InputView;
import automaticlotto.view.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static automaticlotto.domain.Lottos.createLottos;
import static automaticlotto.view.OutputView.showBuyingLottos;

public class AutoLottoController {
    public void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int buyLottoNumbers = OutputView.showLottoNumber(purchaseAmount);
        Lottos lottos = createLottos(buyLottoNumbers);
        showBuyingLottos(lottos);
        Lotto winningLotto = InputView.splitWinningNumbers();
        List<Integer> lottoResult = new ArrayList<>(Collections.nCopies(7, 0));
        LottoWinning lottoWinning = new LottoWinning();
        for (Lotto lotto : lottos.getLottos()) {
            lottoResult = lottoWinning.discriminateLottoNumber(lotto, winningLotto, lottoResult);
        }
        OutputView.showWinningNumber(lottoResult);
        int totalReward = lottoWinning.rankLottoWinner(lottoResult);
        OutputView.showWinningTotalRate(purchaseAmount, totalReward);
    }
}
