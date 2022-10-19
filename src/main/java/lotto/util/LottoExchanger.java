package lotto.util;

import lotto.domain.Lottos;
import lotto.exception.InvalidInputException;

public class LottoExchanger {

    private static final Integer LOTTO_PRICE = 1000;
    private static final String INVALID_UNIT = LOTTO_PRICE + " 단위의 숫자만 입력할 수 있습니다.";

    private LottoExchanger() {
        throw new AssertionError();
    }

    public static Lottos purchaseLottos(Integer purchasePrice) {
        if (purchasePrice % LOTTO_PRICE != 0) {
            throw new InvalidInputException(INVALID_UNIT);
        }
        return new Lottos(purchasePrice / LOTTO_PRICE, purchasePrice);
    }

}
