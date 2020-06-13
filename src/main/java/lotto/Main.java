package lotto;

import lotto.domain.LottoStore;
import lotto.domain.LottosStatistics;
import lotto.domain.data.*;
import lotto.domain.generator.LottoGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        final int buyPriceAmount = InputView.inputBuyAmount();
        final int countManualLottoCount = InputView.inputManualLottoCount();
        final List<List<Integer>> manualLottoInput = InputView.inputManualLottos(countManualLottoCount);

        LottoStore lottoStore = new LottoStore(new LottoGenerator());
        List<ManualLotto> manualLottos = ManualLotto.list(manualLottoInput);
        List<Lotto> lottosBought = lottoStore.buy(PriceLotto.of(buyPriceAmount), manualLottos);
        OutputView.printBuyLottos(lottosBought, manualLottos);

        final List<Integer> winningNumber = InputView.inputWinningNumber();
        final int bonus = InputView.inputBonusNumber();

        final WinningLotto winningLotto = new WinningLotto(LottoNumberPool.get(winningNumber), LottoNumberPool.get(bonus));
        LottosStatistics statistics = new LottosStatistics(lottosBought, PriceLotto.of(buyPriceAmount), winningLotto);
        OutputView.printLottoStatistics(statistics);
    }
}
