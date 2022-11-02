package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private final List<Lottery> lotteries;

    public Customer() {
        lotteries = new ArrayList<>();
    }

    public void purchaseLotteries(int availablePurchaseLotteryAmount, List<Lottery> manualLotteries) {
        validateManualLotteryAmount(availablePurchaseLotteryAmount, manualLotteries.size());
        lotteries.addAll(manualLotteries);
        for (int i = 0; i < availablePurchaseLotteryAmount - manualLotteries.size(); i++) {
            lotteries.add(LotteryCompany.generateRandomLotteryNumbers());
        }
    }

    public List<Lottery> getLotteries() {
        return Collections.unmodifiableList(lotteries);
    }

    private void validateManualLotteryAmount(int availablePurchaseLotteryAmount, int manualPurchaseLotteryAmount) {
        if (manualPurchaseLotteryAmount > availablePurchaseLotteryAmount) {
            throw new IllegalArgumentException("수동 로또 장수는 전체 구매 로또 장수를 초과할 수 없습니다.");
        }
    }
}
