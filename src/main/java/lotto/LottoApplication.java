package lotto;

import calculator.Operation;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;
import java.util.Map;

public class LottoApplication {
    public static void main(String[] args) {
        int amount = LottoInputView.inputAmount();
        LottoStore lottoStore = new LottoStore(amount);
        List<Lotto> lotto = lottoStore.getLotto();

        LottoResultView.printLottoCount(lotto.size());
        LottoResultView.printLotto(lotto);

        String winningLottoNumbers = LottoInputView.inputWinningLottoNumbers();
        Lotto winningLotto = Lotto.from(winningLottoNumbers);
        LottoStatisticalService lottoStatisticalService = new LottoStatisticalService(winningLotto);
        Map<MatchNumberAndPrize, Integer> statistics = lottoStatisticalService.giveStatistics(lotto);

        LottoResultView.printLottoStatistical(statistics);

        Long winningAmountSum = MatchNumberAndPrize.sumWinningAmount(statistics);
        float yield = lottoStatisticalService.calculateYield(amount, winningAmountSum);
        LottoResultView.printYield(yield);
    }
}
