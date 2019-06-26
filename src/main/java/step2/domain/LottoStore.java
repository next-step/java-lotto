package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    public static final Money LOTTO_PRICE = new Money(1_000L);
    private static final LottoStore INSTANCE = new LottoStore();

    private LottoStore() {}

    public static LottoStore getInstance() {
        return INSTANCE;
    }

    public Lottos buyLotto(final Money money) {
        validateMoney(money);
        final int quantity = getLottoQuantity(money);
        final List<Lotto> lottos = createLottos(quantity);
        return salesLottos(lottos, quantity);
    }

    public Lottos buyLotto(final Money money, Lottos selectedNumberLottos) {
        validateMoney(money);
        final Money cost = money.getCost(LOTTO_PRICE, selectedNumberLottos.size());
        final Money restMoney = money.subtractMoney(cost);

        final int quantity = getLottoQuantity(restMoney);
        final List<Lotto> lottos = createLottos(quantity);
        return selectedNumberLottos.appendLottos(salesLottos(lottos, quantity));
    }

    private void validateMoney(final Money money) {
        if (money.getMoney() < LOTTO_PRICE.getMoney()) {
            throw new IllegalArgumentException("로또는 한 개당 " + LOTTO_PRICE.getMoney() + "원 입니다.");
        }
    }

    private int getLottoQuantity(final Money money) {
        return (int) (money.getMoney() / LOTTO_PRICE.getMoney());
    }

    private List<Lotto> createLottos(final int quantity) {
        return IntStream.range(0, quantity)
                        .mapToObj(i -> Lotto.create())
                        .collect(Collectors.toList());
    }

    private Lottos salesLottos(final List<Lotto> lottos, final int quantity) {
        return new Lottos(lottos.subList(0, quantity));
    }
}
