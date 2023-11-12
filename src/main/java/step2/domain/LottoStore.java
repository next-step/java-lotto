package step2.domain;

import step2.exception.InvalidPriceUnitException;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoStore {

    private static final BigDecimal PRICE_PER_SHEET = BigDecimal.valueOf(1000);

    public static int numberOfLotto(BigDecimal price) {
        validate(price);
        return price.divide(PRICE_PER_SHEET).intValue();
    }

    private static void validate(BigDecimal price) {
        if (!isValidUnit(price)) {
            throw new InvalidPriceUnitException();
        }
    }

    private static boolean isValidUnit(BigDecimal price) {
        return price.remainder(PRICE_PER_SHEET).equals(BigDecimal.ZERO);
    }

    public static Lottos lottos(List<LottoNumber> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoStore::lotto)
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    private static Lotto lotto(LottoNumber lottoNumber) {
        return new Lotto(lottoNumber);
    }

}
