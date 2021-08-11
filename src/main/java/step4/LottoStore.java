package step4;

import step4.util.LottoNumberGenerator;

import java.util.Collections;

public class LottoStore {
    public static LottoBucket buyLottoEntries(int numberOf, LottoNumberGenerator lottoNumberGenerator) {
        return Collections.nCopies(numberOf, 0)
                .parallelStream()
                .map(x -> new LottoEntry(lottoNumberGenerator.generateNumbersForLotto()))
                .collect(LottoBucket::new, LottoBucket::add, LottoBucket::merge);
    }
}
