package lottery;

import java.util.ArrayList;
import java.util.List;

public class LotteryWallet {

    private final List<Lottery> lotteries;

    public LotteryWallet() {
        lotteries = new ArrayList<>();
    }

    public LotteryWallet(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }
}
