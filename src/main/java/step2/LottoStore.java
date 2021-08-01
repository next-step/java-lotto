package step2;

import java.util.stream.IntStream;

public class LottoStore {
    private static final int LOTTO_UNIT_PRICE = 1000;

    public static int getAvailableQuantityByBudget(int budget) {
        return budget / LOTTO_UNIT_PRICE;
    }

    public LottoBucket buyLottoEntriesByRandomNumber(int budget, LottoNumberGenerator lottoNumberGenerator) {
        LottoBucket lottoBucket = new LottoBucket();

        IntStream.range(0, getAvailableQuantityByBudget(budget))
                .forEach(x -> lottoBucket.add(lottoNumberGenerator));

        return lottoBucket;
    }
}
