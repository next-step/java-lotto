package lotto.controller;


import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class LotteryController {
    public Inventory inventory = new Inventory();
    public final WinStatistics winStatistics = new WinStatistics();

    public LotteryController() {
    }

    public Money scanMoney() {
        String scanned = InputView.scanWithPayload("Put your money.");
        return new Money(Integer.parseInt(scanned));
    }

    public void createLotteries(Money money) {
        this.inventory.createLotteries(money);
    }

    public void printLotteries() {
        this.inventory.printLotteries();
    }

    public Lottery scanAnswer() {
        String scanned = InputView.scanWithPayload("Put lottery answer.");
        return new Lottery(parseNumbers(scanned));
    }

    public static List<LotteryNumber> parseNumbers(String scanned) {
        return toLotteryNumbers(scanned.split("\\s*,\\s*"));
    }

    public static List<LotteryNumber> toLotteryNumbers(String[] numberStrings) {
        List<LotteryNumber> list = new ArrayList();
        for (String numberString : numberStrings) {
            list.add(toLotteryNumber(numberString));
        }
        return list;
    }

    public static LotteryNumber toLotteryNumber(String numberString) {
        int number = Integer.parseInt(numberString);
        return new LotteryNumber(number);
    }

    public List<Reward> findWins(Winning winning) {
        return this.inventory.findWins(winning);
    }

    public void saveWins(List<Reward> rewards) {
        for (Reward reward : rewards) {
            saveWin(reward);
        }
    }

    public void saveWin(Reward reward) {
        if (reward != Reward.Blank) {
            winStatistics.save(reward);
        }
    }

    public void printWinStatistics() {
        ResultView.printWinStatistics(this.winStatistics.toPayload());
    }

    public void printEarningRate(Money money) {
        String payload = "Earning rate: " + money.profitRate(winStatistics.getEarnedMoney());
        ResultView.print(payload);
    }

    public void printEarned(Money money) {
        ResultView.printEarned(money.profitRate(winStatistics.getEarnedMoney()));
    }

    public int scanBonus() {
        String scanned = InputView.scanWithPayload("Put bonus number.");
        return Integer.parseInt(scanned);
    }

    private void payManualLotteries(Money money, int amount) {
        money.pay(amount);
    }

    public List<Lottery> scanManualLotteries() {
        List<Lottery> scannedNumbers = new ArrayList<>();
        System.out.println("Put manual lottery.(Quit with Carriage return)");
        return scanManualLottery(scannedNumbers);
    }

    private List<Lottery> scanManualLottery(List<Lottery> lotteries) {
        String scanned = InputView.scan();
        if (scanned.length() > 0) {
            List<LotteryNumber> lotteryNumbers = LotteryController.parseNumbers(scanned);
            lotteries.add(new Lottery(lotteryNumbers));
            scanManualLottery(lotteries);
        }
        return lotteries;
    }

    public void start() {
        Money money = this.scanMoney();
        List<Lottery> manualLotteries = this.scanManualLotteries();
        this.payManualLotteries(money, manualLotteries.size());
        this.createLotteries(money);
        this.printLotteries();
        Winning winning = new Winning(this.scanAnswer(), this.scanBonus());
        this.saveWins(this.findWins(winning));
        this.printWinStatistics();
        this.printEarningRate(money);
        this.printEarned(money);
    }

}
