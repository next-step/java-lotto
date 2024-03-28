package lotto.domain.lotto;

import static lotto.utils.Constants.LOTTO_TICKET_PRICE;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import lotto.domain.grade.Grade;
import lotto.domain.winning.WinningNumbers;
import lotto.domain.winning.WinningStatistic;

public class LottoMachine {

    private final PurchaseInfomation purchaseInfomation;

    public LottoMachine(PurchaseInfomation purchaseInfomation) {
        this.purchaseInfomation = purchaseInfomation;
    }

    public WinningStatistic startLotto(List<Lotto> autoLottos, WinningNumbers winningNumbers)
        throws ExecutionException, InterruptedException {
        WinningStatistic winningStatistic = new WinningStatistic(purchaseInfomation);

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
        return purchaseInfomation.getPurchaseAmount() / LOTTO_TICKET_PRICE;
    }

    public Grade calculatePrizeMoney(final WinningNumbers winningNumbers, final Lotto lotto) {
        return winningNumbers.confirmWinning(lotto);
    }
}
