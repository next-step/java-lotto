package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class LottoMarket {
    private static final Money BASE_MONEY_UNIT = new Money(1000);

    private LottoMarket() {
        throw new AssertionError();
    }

    public static Lottos buyLottos(Money money, LottoGenerator lottoGenerator) {
        validate(money, lottoGenerator);
        return getLottos(money, lottoGenerator);
    }

    private static void validate(Money money, LottoGenerator lottoGenerator) {
        Objects.requireNonNull(money, "로또 구매시 지불하는 금액은 null일 수 없습니다.");
        Objects.requireNonNull(lottoGenerator, "로또 생성 전략은 null일 수 없습니다.");
    }

    private static Lottos getLottos(Money money, LottoGenerator lottoGenerator) {
        int count = getUnitCount(money);

        return new Lottos(count, lottoGenerator);
    }

    private static int getUnitCount(Money money) {
        if (!money.isDivided(BASE_MONEY_UNIT)) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액 단위가 올바르지 않습니다. money: " + money);
        }
        return money.getUnitCount(BASE_MONEY_UNIT);
    }
}
