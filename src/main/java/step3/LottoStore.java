package step3;

import step3.util.LottoNumberGenerator;

import java.util.Collections;

public class LottoStore {
    private final LottoPrice lottoPrice;

    public LottoStore(LottoPrice lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public LottoBucket buyLottoEntries(int numberOf, LottoNumberGenerator lottoNumberGenerator) {
        return Collections.nCopies(numberOf, 0)
                .parallelStream()
                .map(x -> new LottoEntry(lottoNumberGenerator.generateNumbersForLotto()))
                .collect(LottoBucket::new, LottoBucket::add, LottoBucket::merge);
    }
}
