package lottery.controller;

import lottery.domain.*;
import lottery.view.Reception;
import lottery.view.ResultView;

import java.util.List;

import static lottery.domain.Money.DEFAULT_LOTTERY_PRICE;

public class LotteryStore {
    public static void main(String[] args) {
        Money money = receiptPrice();

        Lotteries lotteries = generateAndPrintAllLotteries(money);

        WinnerLottery winnerLottery = generateAndPrintWinnerLottery();

        matchResultAndPrintResult(money, lotteries, winnerLottery);
    }

    private static Money receiptPrice() {
        Reception.printToReceiptPrice();
        return Reception.receiptPrice();
    }

    private static Lotteries generateAndPrintAllLotteries(Money money) {
        Reception.printToReceiptManualLotteryCount();

        int receiptCountOfTotal = calculateTotalCountByInputMoney(money);
        int receiptCountOfManual = Reception.receiptNumber();

        GenerateCount manual = GenerateCount.ofManualLottery(receiptCountOfTotal, receiptCountOfManual);
        GenerateCount auto = GenerateCount.ofAutoLottery(receiptCountOfTotal - receiptCountOfManual);

        Reception.printToReceiptManualLottery();
        List<LotteryNumbers> manualLotteryNumbers = Reception.receiptManualLotteries(receiptCountOfManual);

        ResultView.printGenerateCount(auto, manual);

        Lotteries lotteries = new Lotteries(auto, new RandomNumberGenerator(), manualLotteryNumbers);
        ResultView.printAllLotteryNumbers(lotteries.lotteries());
        return lotteries;
    }

    private static int calculateTotalCountByInputMoney(Money money) {
        return money.divide(new Money(DEFAULT_LOTTERY_PRICE));
    }

    private static WinnerLottery generateAndPrintWinnerLottery() {
        LotteryNumbers winnerNumbers = receiptWinnerLottery();
        BonusBall bonusBall = receiptBonusBall();
        return new WinnerLottery(winnerNumbers, bonusBall);
    }

    private static LotteryNumbers receiptWinnerLottery() {
        Reception.printToReceiptWinnerLotteryNumbers();
        return Reception.receiptAndMakeLotteryNumbers();
    }

    private static BonusBall receiptBonusBall() {
        Reception.printToReceiptBonusBall();
        return Reception.receiptBonusBall();
    }

    private static void matchResultAndPrintResult(Money money, Lotteries lotteries, WinnerLottery winnerLottery) {
        MatchCountPair matchCountPair = lotteries.match(winnerLottery);
        ResultView.printToStatisticWinner();
        calculateAndPrintProfit(money, matchCountPair);
    }

    private static void calculateAndPrintProfit(Money money, MatchCountPair matchCountPair) {
        int jackpot = matchCountPair.calculateTotalJackpot();
        ResultView.printMatchCountAndProfit(matchCountPair);
        ResultView.printResultProfit(new Profit(money, new Money(jackpot)).toString());
    }
}
