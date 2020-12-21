package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGame {
    private LotteryAmount lotteryAmount;
    private LotteryWinning lotteryWinning;
    private LotteryTickets lotteryTickets;

    public LotteryGame(int price) {
        this.lotteryAmount = new LotteryAmount(price);
    }

    public int buyNumberOfLotteryTickets() {
        return lotteryAmount.getAmount();
    }

    public void buyLotteryTickets(BuyBehavior behavior) {
        this.lotteryTickets = new LotteryTickets(IntStream.range(0, lotteryAmount.getAmount())
                .boxed()
                .map(Integer -> LotteryTicketFactory.createLotteryTicket(behavior))
                .collect(Collectors.toList()));
    }

    public void createLotteryWiningTicket(String lotteryWiningNumbers, String bunusNumber) {
        this.lotteryWinning = new LotteryWinning(lotteryWiningNumbers, bunusNumber);
    }

    public LotteryResult getLotteryResult() {
        return this.lotteryWinning.analyzeLotteryResult(this.lotteryTickets);
    }

    public LotteryTickets getLotteryTickets() {
        return lotteryTickets;
    }
    public LotteryAmount getLotteryAmount() { return lotteryAmount; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryGame that = (LotteryGame) o;
        return Objects.equals(lotteryAmount, that.lotteryAmount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteryAmount);
    }
}
