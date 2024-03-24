package lotto.domain.lotto;

import java.util.List;
import lotto.domain.grade.Grade;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistic;

public class LottoMachine {

    private final PurchaseAmount purchaseAmount;

    public LottoMachine(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public WinningStatistic startLotto(List<Lotto> autoLottos, WinningNumbers winningNumbers){
        WinningStatistic winningStatistic = new WinningStatistic(purchaseAmount);

        for (Lotto autoLotto : autoLottos) {
            Grade grade = calculatePrizeMoney(winningNumbers, autoLotto);
            winningStatistic.calculateWinningStatistic(grade);
        }

        return winningStatistic;
    }

    public int calculateExecuteCount() {
        return purchaseAmount.getPurchaseAmount() / 1000;
    }

    public Grade calculatePrizeMoney(WinningNumbers winningNumbers, Lotto lotto) {
        return winningNumbers.confirmWinning(lotto);
    }
}
