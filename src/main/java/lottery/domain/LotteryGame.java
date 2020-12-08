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
        if (cost < price) {
            throw new IllegalArgumentException("로또 1장의 가격은 " + this.price + "입니다.");
        }
        return cost / this.price;
    }

    public List<LotteryTicket> buyLotteryTickets(int numberOfTickets, BuyBehavior behavior) {
        return behavior.buyLotteryTickets(this.pickCounts, numberOfTickets);
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
