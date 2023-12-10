package auto.application;

import auto.domain.AutoLotteryRepositoryImpl;
import auto.infrastructure.AutoLotteryRepository;

import java.math.BigDecimal;
import java.util.List;

public class AutoLotteryService {
    private static final int LOTTERY_PRICE = 1000;
    private static final AutoLotteryRepository autoLotteryRepository = new AutoLotteryRepositoryImpl();

    public List<List<Integer>> createLotteryNumbersList(int lotteryCount) {
        return autoLotteryRepository.createLotteryNumbersList(lotteryCount);
    }

    public int getLotteryCount(int purchaseAmount) {
        return purchaseAmount / LOTTERY_PRICE;
    }

    public static BigDecimal getReturnRate(int totalAmount, int amount) {
        return BigDecimal.valueOf(totalAmount)
                         .divide(BigDecimal.valueOf(amount));
    }
}
