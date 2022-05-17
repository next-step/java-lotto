package lotto.controller;


import lotto.model.*;
import lotto.view.InputView;
import lotto.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LotteryController {
    public Inventory inventory = new Inventory();
    public final WinStatistics winStatistics = new WinStatistics();

    public LotteryController() {
    }

    public Money scanMoney() {
        Optional<String> scanned = InputView.scanWithPayload("Put your money.");
        if (scanned.isPresent()) {
            return new Money(Integer.parseInt(scanned.get()));
        }
        throw new NullPointerException("No input found.");
    }

    public void createLotteries(Money money) {
        this.inventory.createLotteries(money);
    }

    public void printLotteries() {
        this.inventory.printLotteries();
    }

    public Lottery scanAnswer() {
        Optional<String> scanned = InputView.scanWithPayload("Put lottery answer.");
        if (scanned.isPresent()) {
            return new Lottery(parseNumbers(scanned.get()));
        }
        throw new NullPointerException("No input found.");
    }

    public static List<LotteryNumber> parseNumbers(String scanned) {
        String[] numbers = scanned.split("\\s*,\\s*");
        if (numbers.length != 6) {
            throw new IllegalArgumentException("Wrong input found: " + String.join(",", numbers));
        }
        return toLotteryNumbers(numbers);
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
        Optional<String> scanned = InputView.scanWithPayload("Put bonus number.");
        if (scanned.isPresent()) {
            return Integer.parseInt(scanned.get());
        }
        throw new NullPointerException("No input found.");
    }

    private void payManualLotteries(Money money, int amount) {
        money.pay(amount);
    }

    private void scanManualLotteries(int amount) {
        this.inventory.scanManualLotteries(amount);
    }

    private int scanManualLotteryAmount() {
        Optional<String> scanned = InputView.scanWithPayload("Put the amount of manual lotteries");
        if (scanned.isPresent()) {
            return Integer.parseInt(scanned.get());
        }
        throw new NullPointerException("No input found");
    }

    public void start() {
        Money money = this.scanMoney();
        int amount = this.scanManualLotteryAmount();
        this.scanManualLotteries(amount);
        this.payManualLotteries(money, amount);
        this.createLotteries(money);
        this.printLotteries();
        Winning winning = new Winning(this.scanAnswer(), this.scanBonus());
        this.saveWins(this.findWins(winning));
        this.printWinStatistics();
        this.printEarningRate(money);
        this.printEarned(money);
    }

}
