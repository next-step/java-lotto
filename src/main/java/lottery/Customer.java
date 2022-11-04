package lottery;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Customer {

    private final List<Lottery> lotteries;

    public Customer() {
        lotteries = new ArrayList<>();
    }

    public void purchaseLotteries(int availablePurchaseAmount, List<Lottery> manualLotteries) {
        int randomLotteryAmount = randomLotteryAmount(availablePurchaseAmount, manualLotteries.size());

        lotteries.addAll(manualLotteries);
        for (int i = 0; i < randomLotteryAmount; i++) {
            lotteries.add(LotteryCompany.randomLottery());
        }
    }

    public List<Lottery> lotteries() {
        return Collections.unmodifiableList(lotteries);
    }

    private int randomLotteryAmount(int availablePurchaseAmount, int manualLotteryAmount) {
        int randomLotteryAmount = availablePurchaseAmount - manualLotteryAmount;
        if (randomLotteryAmount < 0) {
            throw new IllegalArgumentException("수동 로또 장수는 전체 구매 로또 장수를 초과할 수 없습니다.");
        }
        return randomLotteryAmount;
    }
}
