package humbledude.lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class AccountManager {
    public static final long LOTTO_TICKET_PRICE = 1000;

    private final long budget;
    private long amountOfManualLottos = 0;
    private final List<LottoNumbers> tickets = new ArrayList<>();
    private LottoWinningNumbers winningNumbers;

    public AccountManager(long budget) {
        this.budget = budget;
    }

    public void setAmountOfManualLottos(long amount) {
        if (getMaxAmountOfLottos() < amount) {
            throw new IllegalArgumentException("예산을 초과해서 수동 로또를 사려고 하네요");
        }
        this.amountOfManualLottos = amount;
    }

    public long getMaxAmountOfLottos() {
        return budget / LOTTO_TICKET_PRICE;
    }


    public long getAmountOfManualLottos() {
        return amountOfManualLottos;
    }

    public long getAmountOfAutoLottos() {
        return getMaxAmountOfLottos() - amountOfManualLottos;
    }

    public void addTickets(List<LottoNumbers> tickets) {
        this.tickets.addAll(tickets);
    }

    public void setWinningNumbers(LottoWinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public double getProfitRate() {
        double totalSpent = getTotalSpent();
        double totalPrize = getTotalPrize();

        if (totalSpent == 0) {
            throw new IllegalStateException("돈을 하나도 안썼어요. 돈을 쓰고 수익률을 계산합시다");
        }

        return totalPrize / totalSpent;
    }

    public List<LottoNumbers> getTickets() {
        return tickets;
    }

    public Map<LottoPrize, List<LottoNumbers>> getResultMap() {
        return tickets.stream()
                .collect(Collectors.groupingBy(winningNumbers::claimPrize));
    }

    private long getTotalPrize() {
        AtomicLong totalPrize = new AtomicLong(0L);
        getResultMap().forEach((prize, tickets) -> totalPrize.addAndGet(prize.getPrize() * tickets.size()));

        return totalPrize.get();
    }

    private long getTotalSpent() {
        return tickets.size() * LOTTO_TICKET_PRICE;
    }

    public void buyAutoTicketsWithRemainingBudget() {
        long howMany = getAmountOfAutoLottos();

        List<LottoNumbers> autoLottos = LongStream.range(0, howMany)
                .mapToObj(i -> AutoLotto.buildTicket())
                .collect(Collectors.toList());

        addTickets(autoLottos);
    }

}
