package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottoes;
import lotto.view.InputView;
import lotto.view.OutputView;

public final class LottoMachine {

    public static final int LOTTO_SIZE = 6;

    public static final int PAY = 1000;

    private final InputView inputView;

    private final OutputView outputView;

    public LottoMachine() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void purchaseAndCheck() {
        int totalLottoCount = inputView.inputPurchaseCount();
        int manualLottoCount = inputView.inputManualLottoCount();
        int autoLottoCount = totalLottoCount - manualLottoCount;

        Lottoes manualLottoes = inputView.inputManualLottoes(manualLottoCount);
        Lottoes autoLottoes = new Lottoes(autoLottoCount);

        outputView.showPurchaseCount(manualLottoCount, autoLottoCount);
        outputView.showPurchasedLottoes(autoLottoes);

        Lotto winningLotto = inputView.inputWinningNumbers();
        LottoNumber bonusBall = inputView.inputBonusBall();
        LottoChecker lottoChecker = new LottoChecker(winningLotto, bonusBall);

        LottoResult result = new LottoResult(lottoChecker, manualLottoes, autoLottoes);
        outputView.showStatistics(result, totalLottoCount * PAY);
    }
}
