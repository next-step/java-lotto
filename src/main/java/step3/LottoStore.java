package step3;

import step3.util.LottoNumberGenerator;

import java.util.Collections;

public class LottoStore {
    private final LottoPrice lottoPrice;

    public LottoStore(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public LottoBucket buyLottoEntries(int budget, LottoNumberGenerator lottoNumberGenerator) {
        int numberOfLottoEntries = lottoPrice.getMaxQuantity(budget);

        return Collections.nCopies(numberOfLottoEntries, 0)
                .parallelStream()
                .map(x -> new LottoEntry(lottoNumberGenerator.generateNumbersForLotto()))
                .collect(LottoBucket::new, LottoBucket::add, LottoBucket::merge);
    }
}
