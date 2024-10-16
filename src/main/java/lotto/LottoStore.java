package lotto;

import lotto.domain.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.List;

public class LottoStore {
    private final InputView inputView;
    private final ResultView resultView;
    private final LottoGenerator lottoGenerator;

    public LottoStore(InputView inputView, ResultView resultView, LottoGenerator lottoGenerator) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.lottoGenerator = lottoGenerator;
    }

    public void buy() {
        int lottoAmount = inputView.receivePurchasingAmount();
        List<Lotto> manualLottoNumbers = inputView.receiveManualLotto();
        Lottos lottos = lottoGenerator.getLottos(lottoAmount, manualLottoNumbers);

        resultView.printLottoResult(lottos);

        List<LottoNumber> winningNumber = inputView.receiveWinningNumber();
        LottoNumber bonusNumber = inputView.receiveBonusNo();
        lottos.calculateLotto(new WinningNumber(winningNumber, bonusNumber));

        resultView.printLottoStatistics(lottos, inputView.getPurchasingAmount());
    }
}
