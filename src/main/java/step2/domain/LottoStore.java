package step2.domain;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoStore {
    public static final Money LOTTO_PRICE = new Money(1000L);

    public Lottos buyLotto(final Money money) {
        validateMoney(money);
        final int quantity = getLottoQuantity(money);
        return makeLottos(quantity);
    }

    public Lottos buyLotto(final Money money, ChooseLottos chooseLottos) {
        validateMoney(money);
        final int quantity = getLottoQuantity(money);
        return new Lottos(chooseLottos.receiveLottos(quantity));
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
}
