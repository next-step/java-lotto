package lottery.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LotteryGame {

    private final int price;

    public LotteryGame(int price) {
        this.price = price;
    }

    public int buyNumberOfLotteryTickets(int cost) {
        if (cost < price) {
            throw new IllegalArgumentException("로또 1장의 가격은 " + this.price + "입니다.");
        }
        return cost / this.price;
    }

    public LotteryTickets buyLotteryTickets(int numberOfTickets, BuyBehavior behavior) {
        return new LotteryTickets(IntStream.range(0, numberOfTickets)
                .boxed()
                .map(Integer -> LotteryTicketFactory.createLotteryTicket(behavior))
                .collect(Collectors.toList()));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LotteryGame that = (LotteryGame) o;
        return price == that.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
