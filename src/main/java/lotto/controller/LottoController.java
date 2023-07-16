package lotto.controller;

import lotto.model.AutoLottos;
import lotto.model.Lotto;
import lotto.model.LottoCounts;
import lotto.model.LottoMoney;
import lotto.model.LottoNumber;
import lotto.model.LottoResult;
import lotto.model.ManualLottos;
import lotto.model.RankResultsDto;
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
        LottoMoney lottoMoney = inputLottoMoney();
        LottoCounts lottoCounts = inputLottoCounts(lottoMoney);

        ManualLottos manualLottos = lottoInputView.inputManualLottoNumbers(
                lottoCounts.getManualLottoCount());
        AutoLottos autoLottos = new AutoLottos(lottoCounts.getAutoLottoCount(),
                RandomNumbersGenerator.getInstance());

        printAutoLottos(lottoMoney, lottoCounts, autoLottos);

        WinningNumbers totalWinningNumbers = getWinningNumbers();
        RankResultsDto totalRankResultsDto = RankResultsDto.add(
                manualLottos.matchWinningNumbers(totalWinningNumbers),
                autoLottos.matchWinningNumbers(totalWinningNumbers)
        );
        LottoResult lottoResult = new LottoResult(totalRankResultsDto, lottoMoney);
        lottoOutputView.printLottoResult(lottoResult);
    }

    private LottoMoney inputLottoMoney() {
        int inputMoney = lottoInputView.inputMoney();
        return new LottoMoney(inputMoney);
    }

    private LottoCounts inputLottoCounts(LottoMoney lottoMoney) {
        int manualLottoCount = lottoInputView.inputManualLottoCount();
        return new LottoCounts(lottoMoney.getTotalCount(), manualLottoCount);
    }

    private void printAutoLottos(LottoMoney lottoMoney, LottoCounts lottoCounts,
            AutoLottos autoLottos) {
        lottoOutputView.printBuyingCount(lottoCounts);
        lottoOutputView.printChange(lottoMoney);
        lottoOutputView.printBuyingLotto(autoLottos);
    }

    private WinningNumbers getWinningNumbers() {
        Lotto winningNumbers = lottoInputView.inputWinningNumbers();
        LottoNumber bonusBall = lottoInputView.inputBonusBall();

        return new WinningNumbers(winningNumbers, bonusBall);
    }
}
