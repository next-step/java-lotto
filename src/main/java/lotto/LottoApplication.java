package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        Money buyAmount = InputView.inputBuyAmount();
        long manualCount = InputView.inputManualCount();
        Lottos manualLottos = InputView.inputManualLottos(manualCount);
        long autoCount = calculateAutoCount(buyAmount, manualCount);
        Lottos autoLottos = LottoGenerator.generate(autoCount);
        ResultView.printLottos(manualLottos.toDto(), autoLottos.toDto());

        Lottos lottos = manualLottos.addAll(autoLottos);

        String winningNumbers = InputView.inputWinningNumbers();
        LottoNumber bonus = InputView.inputBonusNumber();

        Lotto winningLotto = LottoGenerator.generate(winningNumbers);
        RankResult rankResult = lottos.countMatching(new WinningLotto(winningLotto, bonus));
        ResultView.printWinningMatchCount(rankResult.toDto());
        ResultView.printRateOfEarning(rankResult.calculateRateOfEarning(buyAmount));
    }

    private static long calculateAutoCount(Money buyAmount, long manualCount) {
        return buyAmount.toLong() / Lotto.LOTTO_AMOUNT.toLong() - manualCount;
    }
}
