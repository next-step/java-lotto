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

    public List<Lottery> purchaseLotteries(Money purchaseMoney, List<List<Integer>> manualNumbers) {
        lotteries.addAll(new RandomGenetator(purchaseMoney).generate());
        lotteries.addAll( new ManualGenerator(manualNumbers, purchaseMoney).generate());
        return lotteries;
    }

    public LotteryResult checkWinning(List<Lottery> lotteries, Lottery winningNumbers) {
        List<RANK> comparedResults = new ArrayList<>();
        lotteries.forEach(lottery -> {
            comparedResults.add(lottery.winCheck(winningNumbers));
        });
        return new LotteryResult(comparedResults);
    }
}
