package step2;

import step2.domain.LotteryNumber;
import step2.domain.LotteryResult;
import step2.domain.LotteryTicket;
import step2.domain.LotteryWinningRank;

import java.util.ArrayList;
import java.util.List;

import static step2.view.InputView.getTotalCount;
import static step2.view.InputView.getWinningNumbers;
import static step2.view.InputView.inputPurchaseAmount;
import static step2.view.OutputView.printLotteryNumbers;
import static step2.view.OutputView.result;

public class LotteryMain {

    public static void main(String[] args) {
        int purchaseAmount = inputPurchaseAmount();
        int totalCount = getTotalCount(purchaseAmount);

        List<LotteryTicket> lotteryTickets = new ArrayList<>();
        LotteryNumber lotteryNumber = new LotteryNumber();
        for (int i = 0; i < totalCount; i++) {
            List<Integer> lotteryNumberList = lotteryNumber.createLotteryNumber();
            lotteryTickets.add(new LotteryTicket(lotteryNumberList));
            printLotteryNumbers(lotteryNumberList);
        }

        LotteryResult lotteryResult = new LotteryResult(getWinningNumbers());
        LotteryWinningRank lotteryWinningRank = new LotteryWinningRank();
        for (LotteryTicket lotteryTicket : lotteryTickets) {
            long matchingNum = lotteryResult.countMatchingNum(lotteryTicket);
            lotteryWinningRank.createStatistics(matchingNum);
        }

        result(purchaseAmount, lotteryWinningRank.getWinningCountMap());
    }
}
