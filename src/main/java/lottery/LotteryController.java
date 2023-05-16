package lottery;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LotteryController {
    private final LotteryView lotteryView = new LotteryView();

    public void runLotterySequence() {
        var credit = chargeLotteryCredit();
        var lotteries = buyLotteries(credit);
        showResults(lotteries);
    }

    private void showResults(List<Lottery> lotteries) {
        var winningNumbers = lotteryView.getWinningNumbers();
        var bonusNumber = lotteryView.getBonusNumber();
        var drawResult = new DrawResult(winningNumbers, bonusNumber);
        var statistics = new LotteryStatistics(lotteries, drawResult);
        lotteryView.showStatistics(statistics);
    }

    private List<Lottery> buyLotteries(LotteryCredit credit) {
        var manualQuantity = lotteryView.getManualQuantity();
        var manualRows = lotteryView.getManualNumbers(manualQuantity);
        var lotteries = concatTwoLists(
                buyManualOfRows(manualRows),
                buyAutoWithRemainingCredits(credit)
        );
        lotteryView.showBuyResult(lotteries, manualQuantity);
        return lotteries;
    }

    private LotteryCredit chargeLotteryCredit() {
        var amount = lotteryView.getBuyAmount();
        var credit = new LotteryCredit();
        credit.chargeWithCash(amount);
        return credit;
    }

    private List<Lottery> buyAutoWithRemainingCredits(LotteryCredit credit) {
        return credit.buyLotteriesAuto(credit.getBalance());
    }

    private List<Lottery> buyManualOfRows(List<LotteryRow> rows) {
        return rows.stream()
                .map(Lottery::new)
                .collect(Collectors.toList());
    }

    private <T> List<T> concatTwoLists(List<T> list1, List<T> list2) {
        return Stream.concat(list1.stream(), list2.stream())
                .collect(Collectors.toList());
    }
}
