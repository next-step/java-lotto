package lotto.controller;

import lotto.model.domain.LottoResult;
import lotto.model.domain.RandomNumbersGenerator;
import lotto.model.domain.WinningNumbers;
import lotto.model.service.LottoService;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;

public final class LottoController {

    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    private LottoService lottoService;

    public LottoController() {
        this.lottoInputView = LottoInputView.getInstance();
        this.lottoOutputView = LottoOutputView.getInstance();
    }

    public void run() {
        int inputMoney = lottoInputView.inputMoney();
        this.lottoService = new LottoService(inputMoney, RandomNumbersGenerator.getInstance());
        lottoOutputView.printBuyingCount(lottoService.getLottoMoney());
        lottoOutputView.printBuyingLotto(lottoService.getLottos());
        List<Integer> winningNumbers = lottoInputView.inputWinningNumbers();
        int bonusBall = lottoInputView.inputBonusBall();
        LottoResult lottoResult = lottoService.calculateLottoResult(new WinningNumbers(winningNumbers, bonusBall));
        lottoOutputView.printLottoResult(lottoResult, lottoService.getLottoMoney());
    }
}
