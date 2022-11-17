package lotto.controller;

import lotto.domain.*;
import lotto.domain.enums.MatchNumberAndPrize;
import lotto.service.WinningLotto;
import lotto.view.LottoInputView;
import lotto.view.LottoResultView;

import java.util.List;
import java.util.Map;

public class LottoController {

    public void start() {
        LottoStore lottoStore = createLotto();
        printLotto(lottoStore.getLotto());
        WinningLotto winningLotto = registerWinningLotto();
        resultLotto(winningLotto, lottoStore);
    }

    public LottoStore createLotto() {
        int amount = LottoInputView.inputAmount();
        List<String> manualLottoList = LottoInputView.inputManualLotto();
        return new LottoStore(amount, manualLottoList);
    }

    public void printLotto(List<Lotto> lotto) {
        LottoResultView.printLotto(lotto);
    }

    public WinningLotto registerWinningLotto() {
        String winningLottoNumbers = LottoInputView.inputWinningLottoNumbers();
        Lotto winningLotto = StringLottoNumbers.toLotto(winningLottoNumbers);

        int inputBonusNumber = LottoInputView.inputBonusNumber();
        LottoNumber bonusNumber = LottoNumber.from(inputBonusNumber);

        return new WinningLotto(winningLotto, bonusNumber);
    }

    public void resultLotto(WinningLotto winningLotto, LottoStore lottoStore) {
        Map<MatchNumberAndPrize, Integer> statistics =
                winningLotto.giveStatistics(lottoStore.getLotto());
        LottoResultView.printLottoStatistical(statistics);

        Long winningAmountSum = MatchNumberAndPrize.sumWinningAmount(statistics);
        float yield = lottoStore.calculateYield(winningAmountSum);
        LottoResultView.printYield(yield);
    }
}
