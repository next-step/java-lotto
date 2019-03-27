package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
    private List<Lottery> lotteries = new ArrayList<>();

    public LotteryMachine() {
        new LotteryNumberSet();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public List<Lottery> purchaseLotteries(int inputMoney) {
        for (int purchase = 0; purchase < new Money(inputMoney).purchaseCount(); purchase++) {
            lotteries.add(purchaseLottery());
        }
        return lotteries;
    }

    private Lottery purchaseLottery() {
        return new Lottery();
    }

    public LotteryResult checkWinning(List<Lottery> lotteries, Lottery winningNumbers) {
        List<RANK> comparedResults = new ArrayList<>();
        lotteries.forEach(lottery -> {
            comparedResults.add(lottery.winCheck(winningNumbers));
        });
        return new LotteryResult(comparedResults);
    }
}
