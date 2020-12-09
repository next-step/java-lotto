package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoChecker;
import lotto.domain.LottoNumber;
import lotto.domain.Lottoes;
import lotto.domain.WinningCount;
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
        Lottoes lottoes = new Lottoes(autoLottoCount, manualLottoes);

        outputView.showPurchaseCount(manualLottoCount, autoLottoCount);
        outputView.showPurchasedLottoes(lottoes);

        Lotto winningLotto = inputView.inputWinningNumbers();
        LottoNumber bonusBall = inputView.inputBonusBall();
        WinningCount winningCount =
                new LottoChecker(winningLotto, bonusBall).countWinningLottoes(lottoes);

        outputView.showStatistics(winningCount, totalLottoCount * PAY);
    }
}
