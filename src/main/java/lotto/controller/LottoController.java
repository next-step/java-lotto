package lotto.controller;

import java.util.List;
import lotto.model.domain.LottoResult;
import lotto.model.domain.RandomNumbersGenerator;
import lotto.model.domain.WinningNumbers;
import lotto.model.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public final class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoController() {
        this.lottoInputView = LottoInputView.getInstance();
        this.lottoOutputView = LottoOutputView.getInstance();
    }

    public void run() {
        int inputMoney = lottoInputView.inputMoney();
        final LottoService lottoService = new LottoService(inputMoney,
                RandomNumbersGenerator.getInstance());

        lottoOutputView.printBuyingCount(lottoService.getLottoMoney());
        lottoOutputView.printBuyingLotto(lottoService.getLottos());

        List<Integer> winningNumbers = lottoInputView.inputWinningNumbers();
        int bonusBall = lottoInputView.inputBonusBall();

        LottoResult lottoResult = lottoService.calculateLottoResult(
                new WinningNumbers(winningNumbers, bonusBall));
        lottoOutputView.printLottoResult(lottoResult);
    }
}
