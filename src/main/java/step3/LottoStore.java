package step3;

import java.util.stream.IntStream;

public class LottoStore {
    private final LottoPrice lottoPrice;

    public LottoStore(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public LottoBucket buyLottoEntries(int budget, LottoNumberGenerator lottoNumberGenerator) {
        LottoBucket lottoBucket = new LottoBucket();

        IntStream.range(0, lottoPrice.getMaxQuantity(budget))
                .forEach(x -> lottoBucket.add(lottoNumberGenerator));

        return lottoBucket;
    }
}
