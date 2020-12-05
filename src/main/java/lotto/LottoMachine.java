package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottoes;
import lotto.domain.WinningCount;
import lotto.domain.WinningRecord;
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
        int purchaseCount = inputView.inputPurchaseCount();
        outputView.showPurchaseCount(purchaseCount);

        Lottoes lottoes = new Lottoes(purchaseCount);
        outputView.showPurchasedLottoes(lottoes);

        Lotto winningLotto = inputView.inputWinningNumbers();
        LottoNumber bonusBall = inputView.inputBonusBall();

        WinningRecord record = new WinningRecord(winningLotto, bonusBall);
        WinningCount winningCount = record.record(lottoes);
        outputView.showStatistics(winningCount, purchaseCount * PAY);
    }
}
