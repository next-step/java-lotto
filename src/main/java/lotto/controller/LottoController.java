package lotto.controller;

import lotto.model.domain.AutoLottos;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoMoney;
import lotto.model.domain.LottoNumber;
import lotto.model.domain.LottoResult;
import lotto.model.domain.ManualLottos;
import lotto.model.domain.RankResults;
import lotto.model.domain.WinningNumbers;
import lotto.model.domain.generator.RandomNumbersGenerator;
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
        ManualLottos manualLottos = lottoInputView.inputManualLottoNumbers(
                lottoMoney.getManualLottoCount());
        AutoLottos autoLottos = new AutoLottos(lottoMoney.getAutoCount(),
                RandomNumbersGenerator.getInstance());

        lottoOutputView.printBuyingCount(lottoMoney);
        lottoOutputView.printBuyingLotto(autoLottos);

        Lotto winningNumbers = lottoInputView.inputWinningNumbers();
        LottoNumber bonusBall = lottoInputView.inputBonusBall();

        WinningNumbers totalWinningNumbers = new WinningNumbers(winningNumbers, bonusBall);
        RankResults totalRankResults = new RankResults(
                manualLottos.matchWinningNumbers(totalWinningNumbers),
                autoLottos.matchWinningNumbers(totalWinningNumbers)
        );
        LottoResult lottoResult = new LottoResult(totalRankResults, lottoMoney);
        lottoOutputView.printLottoResult(lottoResult);
    }
}
