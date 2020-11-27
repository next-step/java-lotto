package humbledude.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class AccountManager {
    public static final long LOTTO_TICKET_PRICE = 1000;

    private final Budget budget;
    private final List<LottoNumbers> myLottos = new ArrayList<>();
    private LottoWinningNumbers winningNumbers;

    public AccountManager(long budget) {
        this.budget = new Budget(budget);
    }

    public void buyManualLottos(List<LottoNumbers> numbers) {
        long lottoCost = numbers.size() * LOTTO_TICKET_PRICE;
        budget.addSpending(lottoCost);
        myLottos.addAll(numbers);
    }

    public void buyAutoLottos(long amount) {
        long lottoCost = amount * LOTTO_TICKET_PRICE;
        budget.addSpending(lottoCost);
        List<LottoNumbers> autoLottos = LongStream.range(0, amount)
                .mapToObj(i -> AutoLotto.buildAutoLotto())
                .collect(Collectors.toList());

        myLottos.addAll(autoLottos);
    }

    public long getMaxAmountOfLottosWithinBudget() {
        long remain = budget.getRemain();
        return remain / LOTTO_TICKET_PRICE;
    }

    public void setWinningNumbers(LottoWinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public double getProfitRate() {
        double totalSpending = budget.getTotalSpending();
        double totalPrize = getTotalPrize();

        if (totalSpending == 0) {
            throw new IllegalStateException("돈을 하나도 안썼어요. 돈을 쓰고 수익률을 계산합시다");
        }

        return totalPrize / totalSpending;
    }

    public List<LottoNumbers> getMyLottos() {
        return Collections.unmodifiableList(myLottos);
    }

    public Map<LottoPrize, List<LottoNumbers>> getResultMap() {
        return myLottos.stream()
                .collect(Collectors.groupingBy(winningNumbers::claimPrize));
    }

    private long getTotalPrize() {
        AtomicLong totalPrize = new AtomicLong(0L);
        getResultMap().forEach((prize, tickets) -> totalPrize.addAndGet(prize.getPrize() * tickets.size()));

        return totalPrize.get();
    }
}
