package step2;

import java.util.stream.IntStream;

public class LottoService {
    private static final int LOTTO_UNIT_PRICE = 1000;

    private final int budget;

    public LottoService(int budget) {
        this.budget = budget;
    }

    public static int getLottoQuantityByBudget(int budget) {
        return budget / LOTTO_UNIT_PRICE;
    }

    public LottoBucket generateLottoes(LottoNumberGenerator lottoNumberGenerator) {
        LottoBucket lottoBucket = new LottoBucket();

        IntStream.range(0, getLottoQuantityByBudget(this.budget))
                        .forEach(x -> lottoBucket.addRandomLotto(lottoNumberGenerator));

        return lottoBucket;
    }
}
