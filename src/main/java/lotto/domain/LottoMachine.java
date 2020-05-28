package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_PRICE = 1000;

    public List<Lotto> buy(Price price) {
        int lottoCount = getLottoCount(price);
        return IntStream.range(0, lottoCount).mapToObj(i -> Lotto.generateByAuto()).collect(Collectors.toList());
    }

    private int getLottoCount(Price price) {
        validatePurchasable(price);
        return price.getPrice() / LOTTO_PRICE;
    }

    private void validatePurchasable(Price price) {
        if (price.getPrice() < LOTTO_PRICE) {
            throw new IllegalArgumentException(String.format("`price` is grater than %d", LOTTO_PRICE));
        }
        if (price.getPrice() / LOTTO_PRICE * LOTTO_PRICE != price.getPrice()) {
            throw new IllegalArgumentException(String.format("`price` is must be multiple of %d", LOTTO_PRICE));
        }
    }
}
