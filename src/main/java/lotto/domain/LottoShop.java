package lotto.domain;

import static lotto.common.exception.SystemMessage.*;

import lotto.common.exception.LottoException;

public class LottoShop {

    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private int lottoAmount = ZERO;

    public int countPossibleLottoAmount(final int price) {
        validatePrice(price);
        lottoAmount = price / LOTTO_PRICE;
        return lottoAmount;
    }

    private void validatePrice(final int price) {
        if (price < LOTTO_PRICE) {
            throw new LottoException(MIN_PURCHASE_EXCEPTION_MESSAGE);
        }
        if (price % LOTTO_PRICE != ZERO) {
            throw new LottoException(PER_THOUSAND_EXCEPTION_MESSAGE);
        }
    }

    public Lottos buyLotto() {
        Lottos lottos = new Lottos();
        for (int amount = ZERO; amount < lottoAmount; amount++) {
            lottos.storeLotto(new Lotto());
        }
        return lottos;
    }

}
