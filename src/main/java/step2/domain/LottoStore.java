package step2.domain;

import java.util.List;

import step2.dto.LottosDto;

public class LottoStore {
    public static final Money LOTTO_PRICE = new Money(1_000L);
    private static final LottoStore INSTANCE = new LottoStore();

    private LottoStore() {}

    public static LottoStore getInstance() {
        return INSTANCE;
    }

    public Lottos salesLottos(final Money money, final LottosDto lottosDTO) {
        final var userPickLottos = salesLottos(money, lottosDTO, new UserPickLottosFactory());

        final var usedMoney = userPickLottos.getTotalPrice();
        final var restMoney = money.subtractMoney(usedMoney);

        final var autoPickLottos = salesLottos(restMoney, new AutoPickLottosFactory());

        return userPickLottos.addAll(autoPickLottos);
    }

    private Lottos salesLottos(final Money money, final LottoFactory<LottoQuantity, Lottos> factory) {
        if (hasNo1000Won(money)) {
            return factory.apply(new LottoQuantity(0L));
        }

        final var quantity = money.getLottoQuantity(LOTTO_PRICE);
        return factory.apply(quantity);
    }

    private Lottos salesLottos(final Money money, LottosDto lottosDTO, final LottoFactory<LottosDto, Lottos> factory) {
        if (hasNo1000Won(money)) {
            return factory.apply(new LottosDto(List.of()));
        }

        final var quantity = money.getLottoQuantity(LOTTO_PRICE);
        quantity.validateLottoSize(lottosDTO.getLottos().size());
        return factory.apply(lottosDTO);
    }

    private boolean hasNo1000Won(final Money money) {
        if (money.getMoney() < LOTTO_PRICE.getMoney()) {
            return true;
        }
        return false;
    }
}
