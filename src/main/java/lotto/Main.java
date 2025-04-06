package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class Main {

    public static void main(String[] args) {
        int amount = InputView.inputPurchaseAmount();

        int count = LottoCountCalculator.calculateLottoCount(amount);
        Lottos lottos = buyLottos(count);
        ResultView.printPurchasedLotto(lottos);

        Lotto winningLotto = InputView.inputWinningNumbers();
        LottoResult result = new LottoResult(lottos, winningLotto);

        ResultView.printStatistics(result.getResults(), result.calculateProfitRate(amount));
    }

    private static Lottos buyLottos(int amount) {
        return LottoMachine.buy(amount);
    }
}
