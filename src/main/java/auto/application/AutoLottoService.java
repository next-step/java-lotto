package auto.application;

import auto.domain.AutoLottoRepositoryImpl;
import auto.infrastructure.AutoLottoRepository;

import java.math.BigDecimal;
import java.util.List;

public class AutoLottoService {
    private static final int LOTTERY_PRICE = 1000;
    private static final AutoLottoRepository autoLottoRepository = new AutoLottoRepositoryImpl();

    public static BigDecimal getReturnRate(int totalAmount, int amount) {
        return BigDecimal.valueOf(totalAmount)
                         .divide(BigDecimal.valueOf(amount));
    }

    public List<List<Integer>> createLottoNumbersList(int lotteryCount) {
        return autoLottoRepository.createLottoNumbersList(lotteryCount);
    }

    public int getLottoCount(int purchaseAmount) {
        return purchaseAmount / LOTTERY_PRICE;
    }
}
