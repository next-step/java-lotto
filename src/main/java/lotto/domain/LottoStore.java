package lotto.domain;

import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.domain.lotto.LottosFactory;

import java.util.Objects;

public class LottoStore {
    public static Lottos sell(final Money money) {
        if (Objects.isNull(money)) {
            return Lottos.EMPTY;
        }

        final Money lottoPrice = Lotto.getPrice();
        return createLottos(money, lottoPrice);
    }

    private static Lottos createLottos(final Money money, final Money lottoPrice) {
        final int lottoCount = money.divideWithoutRemainder(lottoPrice);
        return LottosFactory.create(lottoCount);
    }
}
