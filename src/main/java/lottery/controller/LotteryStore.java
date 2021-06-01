package lottery.controller;

import lottery.domain.*;
import lottery.view.Reception;
import lottery.view.ResultView;

public class LotteryStore {
    public static void main(String[] args) {
        Price price = receiptPrice();

        GenerateCount generateCount = generateCount(price);

        Lotteries lotteries = new Lotteries(generateCount, new RandomNumberGenerator());

        WinnerLottery winnerLottery = receiptWinnerLottery(lotteries);

        LotteryFactory lotteryFactory = new LotteryFactory();
        MatchCountPair matchCountPair = lotteryFactory.matchAll(lotteries, winnerLottery);

        ResultView.printToStatisticWinner();

        calculateAndPrintProfit(matchCountPair);
    }

    private static WinnerLottery receiptWinnerLottery(Lotteries lotteries) {
        ResultView.printLotteryNumbers(lotteries);
        return receiptWinnerLottery();
    }

    private static void calculateAndPrintProfit(MatchCountPair matchCountPair) {
        Profit totalProfit = matchCountPair.calculateTotalProfit();
        ResultView.printMatchCountAndProfit(matchCountPair);
        ResultView.printResultProfit(totalProfit.profit());
    }

    private static WinnerLottery receiptWinnerLottery() {
        ResultView.printToReceiptWinnerLotteryNumbers();
        return Reception.receiptWinnerLottery(Reception.receiptString());
    }

    private static GenerateCount generateCount(Price price) {
        GenerateCount generateCount = new GenerateCount(price.calculatePerLottery());
        ResultView.printGenerateCount(generateCount);
        return generateCount;
    }

    private static Price receiptPrice() {
        ResultView.printToReceiptPrice();
        return Reception.receiptPrice();
    }
}
