package automaticlotto.controller;

import automaticlotto.domain.Lotto;
import automaticlotto.domain.LottoWinning;
import automaticlotto.domain.Lottos;
import automaticlotto.view.InputView;
import automaticlotto.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static automaticlotto.domain.Lottos.createLottos;
import static automaticlotto.view.OutputView.showBuyingLottos;

public class AutoLottoController {
    public void startLotto() {
        int purchaseAmount = InputView.enterPurchaseAmount();
        int buyLottoNumbers = OutputView.showLottoNumber(purchaseAmount);
        Lottos lottos = createLottos(buyLottoNumbers);
        showBuyingLottos(lottos);
        Lotto winningLotto = InputView.splitWinningNumbers();
        List<Integer> lottoResult = Arrays.asList("0", "0", "0", "0", "0", "0", "0").stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        LottoWinning lottoWinning = new LottoWinning();
        for (Lotto lotto : lottos.getLottos()) {
            lottoResult = lottoWinning.discriminateLottoNumber(lotto, winningLotto, lottoResult);
        }
        OutputView.showWinningNumber(lottoResult);
        int totalReward = lottoWinning.rankLottoWinner(lottoResult);
        OutputView.showWinningTotalRate(purchaseAmount, totalReward);
    }
}
