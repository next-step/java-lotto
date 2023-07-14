package lotto.controller;

import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMoney;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.LottoResult;
import lotto.model.domain.Lottos;
import lotto.model.domain.WinningNumbers;
import lotto.model.domain.generator.RandomNumbersGenerator;
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
        int manualLottoNumber = lottoInputView.inputManualLottoNumber();
        LottoMoney lottoMoney = new LottoMoney(inputMoney, manualLottoNumber);
        Lottos manualLottos = lottoInputView.inputManualLottoNumbers(
                lottoMoney.getManualLottoCount());

        final LottoService lottoService = new LottoService(
                lottoMoney,
                manualLottos,
                RandomNumbersGenerator.getInstance());

        lottoOutputView.printBuyingCount(lottoService.getLottoMoney());
        lottoOutputView.printBuyingLotto(lottoService.getAutoLottos());

        Lotto winningNumbers = lottoInputView.inputWinningNumbers();
        LottoNumber bonusBall = lottoInputView.inputBonusBall();

        LottoResult lottoResult = lottoService.calculateLottoResult(
                new WinningNumbers(winningNumbers, bonusBall));
        lottoOutputView.printLottoResult(lottoResult);
    }
}
