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

        WinnerLottery winnerLottery = receiptWinnerLottery(lotteries);

        MatchCountPair matchCountPair = lotteries.match(winnerLottery);

        ResultView.printToStatisticWinner();

        calculateAndPrintProfit(money, matchCountPair);
    }

    private static WinnerLottery receiptWinnerLottery(Lotteries lotteries) {
        ResultView.printAllLotteryNumbers(lotteries.lotteries());
        return receiptWinnerLottery();
    }

    private static void calculateAndPrintProfit(Money money, MatchCountPair matchCountPair) {
        int jackpot = matchCountPair.calculateTotalJackpot();
        ResultView.printMatchCountAndProfit(matchCountPair);
        ResultView.printResultProfit(new Profit(money, jackpot).toString());
    }

    private static WinnerLottery receiptWinnerLottery() {
        ResultView.printToReceiptWinnerLotteryNumbers();
        return Reception.receiptWinnerLottery(Reception.receiptString());
    }

    private static GenerateCount generateCount(Money money) {
        GenerateCount generateCount = new GenerateCount(money.divide(DEFAULT_LOTTERY_PRICE));
        ResultView.printGenerateCount(generateCount);
        return generateCount;
    }

    private static Money receiptPrice() {
        ResultView.printToReceiptPrice();
        return Reception.receiptPrice();
    }
}
