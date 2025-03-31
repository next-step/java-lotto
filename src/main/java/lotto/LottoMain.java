package lotto;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.RandomLottoNumberGenerator;
import lotto.domain.WinningResult;

public class LottoMain {

    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        int purchasePrice = InputView.inputPurchasePrice();
        int purchaseAmount = purchasePrice / LOTTO_PRICE;

        Lottos lottos = new Lottos(purchaseAmount, new RandomLottoNumberGenerator());
        OutputView.printPurchaseResult(purchaseAmount, lottos.getLottos());

        Lotto winningLotto = new Lotto(InputView.inputWinningNumbers());
        WinningResult result = lottos.countMatchResults(winningLotto);

        OutputView.printStatistics(result);
        OutputView.printProfitRate(result.calculateProfitRate(purchasePrice));
    }
}
