package lotto;

import lotto.domain.*;
import lotto.domain.data.*;
import lotto.util.Split;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
  /*      final int buyPriceAmount = InputView.inputBuyAmount();
        final int countManualLottoCount = InputView.inputManualLottoCount();
        final List<String> manualLottos = InputView.inputManualLottos(countManualLottoCount);

        LottoStore lottoStore = new LottoStore();
        ManualLottoMemo manualLottoMemo =ManualLottoMemo.of(manualLottos);

        List<Lotto> lottosBought = lottoStore.buy(PriceLotto.of(buyPriceAmount), manualLottoMemo);
        OutputView.printBuyLottos(lottosBought, manualLottoMemo);

        final String winningNumber = InputView.inputWinningNumber();
        final int bonus = InputView.inputBonusNumber();

        final WinningLotto winningLotto = new WinningLotto(LottoNumberPool.get(Split.from(winningNumber, ",")), LottoNumberPool.get(bonus));
        LottosStatistics statistics = new LottosStatistics(lottosBought, PriceLotto.of(buyPriceAmount),
                winningLotto);
        OutputView.printLottoStatistics(statistics);*/
    }
}
