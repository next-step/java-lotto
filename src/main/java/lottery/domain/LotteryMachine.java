package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
    private static final Integer ONE_GAME_MONEY = 1000;
    private List<Lottery> lotteries = new ArrayList<>();

    public LotteryMachine() {
        new LotteryNumberSet();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public List<Lottery> purchaseLotteries(int inputMoney) {
        for (int purchase = 0; purchase < purchaseCount(inputMoney); purchase++) {
            lotteries.add(purchaseLottery());
        }
        return lotteries;
    }

    private int purchaseCount(Integer inputMoney) {
        return inputMoney / ONE_GAME_MONEY;
    }

    private Lottery purchaseLottery() {
        return new Lottery();
    }

    public LotteryResult checkWinning(List<Lottery> lotteries, Lottery winningNumbers) {
        List<Integer> comparedResults = new ArrayList<>();
        lotteries.forEach(lottery -> {
            comparedResults.add(lottery.winCheck(winningNumbers));
        });
        return new LotteryResult(comparedResults);
    }
}
