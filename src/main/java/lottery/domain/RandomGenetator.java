package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class RandomGenetator implements LotteriesGenerator {
    private Money money;

    RandomGenetator(Money money) {
        this.money = money;
    }

    private Lottery purchaseLottery() {
        return new Lottery();
    }

    @Override
    public List<Lottery> generate() {
        List<Lottery> randomLotteries = new ArrayList<>();
        for (int purchase = 0; purchase < money.randomCount(); purchase++) {
            randomLotteries.add(purchaseLottery());
        }
        return randomLotteries;
    }
}
