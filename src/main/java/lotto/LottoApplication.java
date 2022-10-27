package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoStore;
import lotto.domain.enums.MatchNumberAndPrize;
import lotto.service.LottoStatisticalService;
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

        int inputBonusNumber = LottoInputView.inputBonusNumber();
        LottoNumber bonusNumber = LottoNumber.from(inputBonusNumber);

        LottoStatisticalService lottoStatisticalService = new LottoStatisticalService(winningLotto, bonusNumber);
        Map<MatchNumberAndPrize, Integer> statistics = lottoStatisticalService.giveStatistics(lotto);

        LottoResultView.printLottoStatistical(statistics);

        Long winningAmountSum = MatchNumberAndPrize.sumWinningAmount(statistics);
        float yield = lottoStatisticalService.calculateYield(amount, winningAmountSum);
        LottoResultView.printYield(yield);
    }
}
