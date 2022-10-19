package lotto.util;

import lotto.domain.Lottos;
import lotto.exception.InvalidInputException;

public class LottoExchanger {

    private LottoExchanger() {
        throw new AssertionError();
    }

    private static final Integer LOTTO_PRICE = 1000;

    public static Lottos purchaseLottos(Integer purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new InvalidInputException();
        }
        return new Lottos(purchasePrice / LOTTO_PRICE);
    }

}
