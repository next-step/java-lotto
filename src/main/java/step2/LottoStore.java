package step2;

import java.util.Objects;

public class LottoStore {
    public Lottos sell(final Money money) {
        if (Objects.isNull(money)) {
            return Lottos.EMPTY;
        }

        final Money lottoPrice = Lotto.getPrice();
        return createLottos(money, lottoPrice);
    }

    private Lottos createLottos(final Money money, final Money lottoPrice) {
        final int lottoCount = money.divide(lottoPrice);
        return LottosFactory.create(lottoCount);
    }
}
