package step2.domain;

import java.math.BigDecimal;
import java.util.List;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

public class LottoStore {

    private static final BigDecimal PRICE_PER_SHEET = BigDecimal.valueOf(1000);

    public static int numberOfLotto(BigDecimal price) {
        return price.divide(PRICE_PER_SHEET).intValue();
    }

    public static Lottos lottos(List<List<Integer>> lottoNumbers) {
        return lottoNumbers.stream()
            .map(LottoStore::lotto)
            .collect(collectingAndThen(toList(), Lottos::new));
    }

    private static Lotto lotto(List<Integer> lottoNumber) {
        return new Lotto(lottoNumber);
    }

}
