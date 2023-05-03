package lottery;

import java.util.HashSet;

public class LotteryController {
    private final LotteryStand lotteryStand = new LotteryStand();
    private final LotteryStandView lotteryStandView = new LotteryStandConsoleView();
    private final LotteryCalculator lotteryCalculator = new LotteryCalculator();
    private final LotteryCalculatorView lotteryCalculatorView = new LotteryCalculatorConsoleView();

    public void runLotterySequence() {
        var amount = lotteryStandView.getBuyAmount();
        var lotteries = lotteryStand.buyLotteriesOfAmount(amount);
        lotteryStandView.showBuyResult(lotteries);
        var numbersToCompare = new HashSet<>(lotteryCalculatorView.getNumbersToCompare());
        var lotteryCountForNumMatches = lotteryCalculator.getLotteryCountForNumMatches(lotteries, numbersToCompare);
        var pnLResult = lotteryCalculator.getPnLResultFromLotteryCountForNumMatches(lotteryCountForNumMatches, amount);
        lotteryCalculatorView.showResultTitle();
        lotteryCalculatorView.showLotteryCountForNumMatches(lotteryCountForNumMatches);
        lotteryCalculatorView.showPnL(pnLResult);
    }
}
