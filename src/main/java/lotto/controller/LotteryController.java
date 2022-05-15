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
        String scanned = InputView.scan("Put your money.");
        return new Money(Integer.parseInt(scanned));
    }

    public void createLotteries(Money money) {
        this.inventory.createLotteries(money);
    }

    public void printLotteries() {
        this.inventory.printLotteries();
    }

    public Lottery scanAnswer() {
        String scanned = InputView.scan("Put lottery answer.");
        return new Lottery(parseAnswerNumbers(scanned));
    }

    public List<LotteryNumber> parseAnswerNumbers(String scanned) {
        return toLotteryNumbers(scanned.split("\\s*,\\s*"));
    }

    public List<LotteryNumber> toLotteryNumbers(String[] numberStrings) {
        List<LotteryNumber> list = new ArrayList();
        for (String numberString : numberStrings) {
            list.add(toLotteryNumber(numberString));
        }
        return list;
    }

    public LotteryNumber toLotteryNumber(String numberString) {
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
        String scanned = InputView.scan("Put bonus number.");
        return Integer.parseInt(scanned);
    }

    public void start() {
        Money money = this.scanMoney();
        this.createLotteries(money);
        this.printLotteries();
        Winning winning = new Winning(this.scanAnswer(), this.scanBonus());
        this.saveWins(this.findWins(winning));
        this.printWinStatistics();
        this.printEarningRate(money);
        this.printEarned(money);
    }
}
