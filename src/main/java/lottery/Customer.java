package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private final List<Lottery> lotteries;

    public Customer() {
        lotteries = new ArrayList<>();
    }

    public void purchaseRandomLottery() {
        lotteries.add(LotteryCompany.generateRandomLotteryNumbers());
    }

    public List<Lottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
