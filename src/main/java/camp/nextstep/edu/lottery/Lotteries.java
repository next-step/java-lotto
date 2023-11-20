package camp.nextstep.edu.lottery;

import java.util.ArrayList;
import java.util.List;

public class Lotteries {

    public static final int LOTTERY_PRICE = 1000;
    private final List<Lottery> lotteries;
    
    public Lotteries(int money) {
        this.lotteries = new ArrayList<>();

        int lotteryCount = money / LOTTERY_PRICE;
        for (int i = 0; i < lotteryCount; i++) {
            this.lotteries.add(LotteryGenerator.create());
        }
    }

    public int count() {
        return lotteries.size();
    }
}
