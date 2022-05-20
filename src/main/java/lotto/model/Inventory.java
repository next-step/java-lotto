package lotto.model;

import lotto.controller.LotteryController;
import lotto.view.InputView;
import lotto.view.ResultView;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.util.Const.PAYLOAD_NO_INPUT;

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
        this.manualLotteries = new ArrayList<>();
    }

    public void createLotteries(Money money) {
        while (money.enough()) {
            money = buyLottery(money);
        }
    }

    public Money buyLottery(Money money) {
        if (!money.enough()) {
            throw new IllegalCallerException("Not enough money.");
        }
        this.lotteries.add(new Lottery());
        return money.pay(1);
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
        List<Lottery> totalLotteries = Stream.of(this.lotteries, this.manualLotteries)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
        for (Lottery lottery : totalLotteries) {
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
        Optional<String> scanned = InputView.scan();
        if (scanned.isPresent()) {
            try {
                TreeSet<LotteryNumber> lotteryNumbers = LotteryController.parseNumbers(scanned.get());
                return new Lottery(lotteryNumbers);
            } catch (Exception e) {
                System.out.println(e);
                return this.scanManualLottery();
            }
        }
        System.out.println(PAYLOAD_NO_INPUT);
        return this.scanManualLottery();
    }

}
