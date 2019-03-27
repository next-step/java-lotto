package lottery.domain;

import java.util.ArrayList;
import java.util.List;

public class LotteryMachine {
    public static final int AVAILABLE_PURCHASE_VALUE = 0;
    private List<Lottery> lotteries = new ArrayList<>();

    public LotteryMachine() {
        new LotteryNumberSet();
    }

    public List<Lottery> getLotteries() {
        return lotteries;
    }

    public List<Lottery> purchaseLotteries(Money purchaseCount, int manualCount, List<List<Integer>> manualNumbers) {
        int autoPurchaseCount = initAutoPurchaseCount(manualCount, purchaseCount.purchaseCount());
        checkValidation(manualCount, manualNumbers.size(), autoPurchaseCount);
        purchase(manualNumbers, autoPurchaseCount);
        return lotteries;
    }

    private void purchase(List<List<Integer>> manualNumbers, int autoPurchaseCount) {
        purchaseAutoLotteries(autoPurchaseCount);
        purchaseManualLotteries(manualNumbers);
    }

    private void purchaseManualLotteries(List<List<Integer>> manualNumbers) {
        for (List<Integer> manualNumber : manualNumbers) {
            lotteries.add(new Lottery(manualNumber));
        }
    }

    private void purchaseAutoLotteries(int autoPurchaseCount) {
        for (int purchase = 0; purchase < autoPurchaseCount; purchase++) {
            lotteries.add(purchaseLottery());
        }
    }
    
    private void checkValidation(int manualCount, int manualLotterySize, int autoPurchaseCount) {
        if(autoPurchaseCount < AVAILABLE_PURCHASE_VALUE) {
            throw new IllegalArgumentException("내신 돈보다 더 많은 걸 살 순 없어요!");
        }
        if(manualCount != manualLotterySize) {
            throw new IllegalArgumentException("수동 개수만큼의 로또용지를 체크해주세요!");
        }
    }

    private int initAutoPurchaseCount(int manualCount, int purchaseCount) {
        return purchaseCount - manualCount;
    }

    private Lottery purchaseLottery() {
        return new Lottery();
    }

    public LotteryResult checkWinning(List<Lottery> lotteries, Lottery winningNumbers) {
        List<RANK> comparedResults = new ArrayList<>();
        lotteries.forEach(lottery -> {
            comparedResults.add(lottery.winCheck(winningNumbers));
        });
        return new LotteryResult(comparedResults);
    }
}
