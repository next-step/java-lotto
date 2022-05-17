package lotto.model;

import lotto.controller.LotteryController;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Lottery> lotteries;
    private List<Lottery> manualLotteries;

    public Inventory() {
        this.lotteries = new ArrayList();
        this.manualLotteries = new ArrayList<>();
    }

    ;

    public Inventory(List<Lottery> lotteries) {
        this.lotteries = lotteries;
    }

    public void createLotteries(Money money) {
        while (money.enough()) {
            buyLottery(money);
        }
    }

    public void buyLottery(Money money) {
        if (!money.enough()) {
            throw new IllegalCallerException("Not enough money.");
        }
        money.pay(1);
        this.lotteries.add(new Lottery());
    }

    public int getLotteriesSize() {
        return this.lotteries.size();
    }

    public void printLotteries() {
        ResultView.printLotteries(this.manualLotteries, "manual");
        ResultView.printLotteries(this.lotteries, "auto");
    }

    public List<Reward> findWins(Winning winning) {
        List<Reward> rewards = new ArrayList();
        for (Lottery lottery : this.lotteries) {
            Reward reward = lottery.findWin(winning);
            rewards.add(reward);
        }
        return rewards;
    }

    public void scanManualLotteries(int amount) {
        List<Lottery> manualLotteries = new ArrayList<>();
        System.out.println("Put manual lottery.(" + amount + " times)");
        for (int i = 0; i < amount; i++) {
            manualLotteries.add(scanManualLottery());
        }
        this.manualLotteries = manualLotteries;
    }

    private Lottery scanManualLottery() {
        String scanned = InputView.scan();
        List<LotteryNumber> lotteryNumbers = LotteryController.parseNumbers(scanned);
        return new Lottery(lotteryNumbers);
    }

}
