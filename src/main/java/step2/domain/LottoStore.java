package step2.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    private static final Money LOTTO_PRICE = new Money(1_000L);
    private static final LottoStore INSTANCE = new LottoStore();

    private LottoStore() {}

    public static LottoStore getInstance() {
        return INSTANCE;
    }

    public Lottos buyLotto(final Money money) {
        validateMoney(money);
        final int quantity = getLottoQuantity(money);
        return makeLottos(quantity);
    }

    public Lottos buyLotto(final Money money, Lottos selectionNumberLottos) {
        validateMoney(money);
        final int quantity = getLottoQuantity(money);
        return new Lottos(giveLottos(selectionNumberLottos, quantity));
    }

    private void validateMoney(final Money money) {
        if (money.getMoney() < LOTTO_PRICE.getMoney()) {
            throw new IllegalArgumentException("로또는 한 개당 " + LOTTO_PRICE.getMoney() + "원 입니다.");
        }
    }

    private int getLottoQuantity(final Money money) {
        return (int) (money.getMoney() / LOTTO_PRICE.getMoney());
    }

    private Lottos makeLottos(final int quantity) {
        return new Lottos(IntStream.range(0, quantity)
                                   .mapToObj(i -> Lotto.create())
                                   .collect(Collectors.toList()));
    }

    private List<Lotto> giveLottos(final Lottos selectionNumberLottos, final int quantity) {
        return selectionNumberLottos.getLottos().subList(0, quantity);
    }
}
