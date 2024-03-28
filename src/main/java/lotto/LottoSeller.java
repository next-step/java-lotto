package lotto;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoSeller {
    private static final int PRICE_PER_ONE_LOTTO = 1_000;

    public static Lottos sell(Money money, LottoNumberStrategy strategy) {
        return new Lottos(getLottoCountToBuy(money), strategy);
    }

    public static Lottos sell(BuyLotto buyLotto) {
        List<LottoNumberStrategy> auto = IntStream.range(0, getAutoLottoCount(buyLotto))
                .mapToObj(it -> RandomLottoNumberStrategy.CACHED)
                .collect(Collectors.toList());

        auto.addAll(buyLotto.getManualLottos());
        return new Lottos(auto);
    }

    private static int getAutoLottoCount(BuyLotto buyLotto) {
        return getLottoCountToBuy(buyLotto.getMoney()) - buyLotto.manualLottoCount();
    }

    private static int getLottoCountToBuy(Money money) {
        return money.divide(PRICE_PER_ONE_LOTTO);
    }

}
