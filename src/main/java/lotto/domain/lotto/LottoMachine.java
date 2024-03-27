package lotto.domain.lotto;

import static lotto.utils.constants.LOTTO_TICKET_PRICE;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lotto.domain.grade.Grade;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistic;

public class LottoMachine {

    private final PurchaseAmount purchaseAmount;

    public LottoMachine(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public WinningStatistic startLotto(List<Lotto> autoLottos, WinningNumbers winningNumbers)
        throws ExecutionException, InterruptedException {
        WinningStatistic winningStatistic = new WinningStatistic(purchaseAmount);

        CompletableFuture<Void>[] futures = autoLottos.stream()
            .map(autoLotto -> calculateGrade(winningNumbers, autoLotto)
                .thenAccept(grade -> winningStatistic.calculateWinningStatistic(grade)))
            .toArray(CompletableFuture[]::new);

        waitLotto(futures);

        return winningStatistic;
    }

    private void waitLotto(CompletableFuture<Void>[] futures)
        throws InterruptedException, ExecutionException {
        CompletableFuture.allOf(futures).get();
    }

    public CompletableFuture<Grade> calculateGrade(WinningNumbers winningNumbers, Lotto lotto) {
        return CompletableFuture.supplyAsync(() -> winningNumbers.confirmWinning(lotto));
    }


    public int calculateExecuteCount() {
        return purchaseAmount.getPurchaseAmount() / LOTTO_TICKET_PRICE;
    }

    public Grade calculatePrizeMoney(final WinningNumbers winningNumbers, final Lotto lotto) {
        return winningNumbers.confirmWinning(lotto);
    }
}
