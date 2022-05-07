package lotto.model;

import java.util.Objects;


public class LottoMarket {
    private static final Money BASE_MONEY_UNIT = new Money(1000);

    private LottoMarket() {
        throw new AssertionError();
    }

    public static Lottos buyLottos(Money money, LottoGenerator lottoGenerator) {
        validate(money, lottoGenerator);
        return generateLottos(money, lottoGenerator);
    }

    private static void validate(Money money, LottoGenerator lottoGenerator) {
        Objects.requireNonNull(money, "로또 구매시 지불하는 금액은 null일 수 없습니다.");
        Objects.requireNonNull(lottoGenerator, "로또 생성 전략은 null일 수 없습니다.");
    }

    private static Lottos generateLottos(Money money, LottoGenerator lottoGenerator) {
        if (!money.isDivided(BASE_MONEY_UNIT)) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액 단위가 올바르지 않습니다. money: " + money);
        }

        return new Lottos(money.calculateUnitCount(BASE_MONEY_UNIT), lottoGenerator);
    }
}
