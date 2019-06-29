package step2.domain;

import java.util.function.Function;

import step2.dto.LottosDTO;

public class LottoStore {
    public static final Money LOTTO_PRICE = new Money(1_000L);
    private static final LottoStore INSTANCE = new LottoStore();

    private LottoStore() {}

    public static LottoStore getInstance() {
        return INSTANCE;
    }

    public Lottos salesLottos(final Money money, final Function<LottoQuantity, Lottos> factory) {
        validateMoney(money);
        final LottoQuantity quantity = money.getLottoQuantity(LOTTO_PRICE);
        return factory.apply(quantity);
    }

    public Lottos salesLottos(final Money money, LottosDTO lottosDTO, final Function<LottosDTO, Lottos> factory) {
        validateMoney(money);
        final LottoQuantity quantity = money.getLottoQuantity(LOTTO_PRICE);
        quantity.validateLottoSize(lottosDTO.getLottos().size());
        return factory.apply(lottosDTO);
    }

    private void validateMoney(final Money money) {
        if (money.getMoney() < LOTTO_PRICE.getMoney()) {
            throw new IllegalArgumentException("로또는 한 개당 " + LOTTO_PRICE.getMoney() + "원 입니다.");
        }
    }
}
