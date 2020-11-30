package lottery.domain;

import java.util.*;

public class LotteryGame {

    private final int price;
    private final int pickCounts;

    public LotteryGame(int price, int pickCounts) {
        this.price = price;
        this.pickCounts = pickCounts;
    }

    public int buyNumberOfLotteryTickets(int cost) {
        return cost / this.price;
    }

    public List<LotteryTicket> buyLotteryTickets(int numberOfTickets) {
        AutoBuyBehavior autoBuyBehavior = new AutoBuyBehavior();
        return autoBuyBehavior.buyLotteryTickets(this.pickCounts, numberOfTickets);
    }

    public LotteryResult matchLotteryTickets(String winningNumbers, List<LotteryTicket> lotteryTickets) {
        LotteryResult lotteryResult = new LotteryResult(winningNumbers);
        return lotteryResult.match(lotteryTickets);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryGame that = (LotteryGame) o;
        return price == that.price &&
                pickCounts == that.pickCounts;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, pickCounts);
    }
}
