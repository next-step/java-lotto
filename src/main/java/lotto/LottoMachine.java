package lotto;

import lotto.domain.Lotto;
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

    public void purchase() {
        int totalLottoCount = inputView.inputPurchaseCount();
        int manualLottoCount = inputView.inputManualLottoCount();
        int automaticLottoCount = totalLottoCount - manualLottoCount;

        Lottoes lottoes = new Lottoes(automaticLottoCount);
        outputView.showPurchaseCount(manualLottoCount,automaticLottoCount);
        outputView.showPurchasedLottoes(lottoes);

        Lotto winningLotto = inputView.inputWinningNumbers();
        LottoNumber bonusBall = inputView.inputBonusBall();

        WinningCount winningCount = lottoes.countWinLotto(winningLotto, bonusBall);
        outputView.showStatistics(winningCount, totalLottoCount * PAY);
    }
}
