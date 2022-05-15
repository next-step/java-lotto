package lotto.model;

import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Lottery> lotteries;

    public Inventory(){
        this.lotteries = new ArrayList();
    };

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
        money.pay();
        this.lotteries.add(new Lottery());
    }

    public int getLotteriesSize() {
        return this.lotteries.size();
    }

    public void printLotteries() {
        ResultView.printLotteries(this.lotteries);
    }

    public List<Reward> findWins(Winning winning) {
        List<Reward> rewards = new ArrayList();
        for (Lottery lottery : this.lotteries) {
            Reward reward = lottery.findWin(winning);
            rewards.add(reward);
        }
        return rewards;
    }
}
