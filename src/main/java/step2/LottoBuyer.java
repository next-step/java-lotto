package step2;

import java.util.Objects;

import static util.Preconditions.checkArgument;

public class LottoBuyer {
    public static final String MONEY_MUST_NOT_BE_NULL = "money must not be null";
    private final Money money;
    private Lottos lottos = Lottos.EMPTY;

    private LottoBuyer(final Money money) {
        this.money = money;
    }

    public static LottoBuyer of(final Money money) {
        checkArgument(Objects.nonNull(money), MONEY_MUST_NOT_BE_NULL);
        return new LottoBuyer(money);
    }

    public void buy(final LottoStore lottoStore) {
        this.lottos = lottoStore.sell(money);
    }

    public Lottos getLottos() {
        return lottos;
    }
}
