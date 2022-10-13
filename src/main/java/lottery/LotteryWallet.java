package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LotteryWallet {

    private final List<Lottery> lotteries;

    public LotteryWallet() {
        this(new ArrayList<>());
    }

    public LotteryWallet(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public void generateLottery(int generateLotteryCount) {
        for (int i = 0; i < generateLotteryCount; i++) {
            lotteries.add(new Lottery(Lottery.generateRandomLotteryNumbers()));
        }
    }

    public List<Lottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }
}
