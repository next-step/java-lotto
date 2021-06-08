package lottery.controller;

import lottery.domain.*;
import lottery.view.Reception;
import lottery.view.ResultView;

import static lottery.domain.Money.DEFAULT_LOTTERY_PRICE;

public class LotteryStore {
    public static void main(String[] args) {
        Money money = receiptPrice();

        GenerateCount generateCount = generateCount(money);

        Lotteries lotteries = new Lotteries(generateCount, new RandomNumberGenerator());

        ResultView.printAllLotteryNumbers(lotteries.lotteries());

        LotteryNumbers winnerNumbers = receiptWinnerLottery();
        BonusBall bonusBall = receiptBonusBall();
        WinnerLottery winnerLottery = new WinnerLottery(winnerNumbers, bonusBall);

        MatchCountPair matchCountPair = lotteries.match(winnerLottery);

        ResultView.printToStatisticWinner();

        calculateAndPrintProfit(money, matchCountPair);
    }

    private static BonusBall receiptBonusBall() {
        ResultView.printToReceiptBonusBall();
        return Reception.receiptBonusBall();
    }

    private static void calculateAndPrintProfit(Money money, MatchCountPair matchCountPair) {
        int jackpot = matchCountPair.calculateTotalJackpot();
        ResultView.printMatchCountAndProfit(matchCountPair);
        ResultView.printResultProfit(new Profit(money, new Money(jackpot)).toString());
    }

    private static LotteryNumbers receiptWinnerLottery() {
        ResultView.printToReceiptWinnerLotteryNumbers();
        return Reception.receiptWinnerLottery(Reception.receiptString());
    }

    private static GenerateCount generateCount(Money money) {
        GenerateCount generateCount = new GenerateCount(money.divide(new Money(DEFAULT_LOTTERY_PRICE)));
        ResultView.printGenerateCount(generateCount);
        return generateCount;
    }

    private static Money receiptPrice() {
        ResultView.printToReceiptPrice();
        return Reception.receiptPrice();
    }
}
