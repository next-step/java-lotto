package lotto.controller;

import lotto.model.AutoLottos;
import lotto.model.Lotto;
import lotto.model.LottoMoney;
import lotto.model.LottoNumber;
import lotto.model.LottoResult;
import lotto.model.ManualLottos;
import lotto.model.RankResults;
import lotto.model.WinningNumbers;
import lotto.model.generator.RandomNumbersGenerator;
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
