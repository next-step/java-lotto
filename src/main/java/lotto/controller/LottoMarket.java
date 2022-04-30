package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class LottoMarket {

    private static final int DEFAULT_VALUE = 0;
    private static final int ADD_COUNT = 1;
    private static final Money BASE_MONEY_UNIT = new Money(1000);

    private LottoMarket() {
        throw new AssertionError();
    }

    public static List<Lotto> buyLottos(Money money, LottoGenerator lottoGenerator) {
        validate(money);
        return getLottos(money, lottoGenerator);
    }

    private static void validate(Money money) {
        Objects.requireNonNull(money, "로또 구매시 지불하는 금액은 null일 수 없습니다.");
    }

    private static List<Lotto> getLottos(Money money, LottoGenerator lottoGenerator) {
        int count = getUnitCount(money);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.get());
        }

        return lottos;
    }

    private static int getUnitCount(Money money) {
        if (!money.isDivided(BASE_MONEY_UNIT)) {
            throw new IllegalArgumentException("로또 구매시 지불하는 금액 단위가 올바르지 않습니다. money: " + money);
        }
        return money.getUnitCount(BASE_MONEY_UNIT);
    }

    public static Map<Integer, Integer> getLottoStatistics(List<Lotto> buyingLottos, Lotto winnerLotto) {
        validate(buyingLottos, winnerLotto);
        Map<Integer, Integer> result = new HashMap<>();
        for (Lotto lotto : buyingLottos) {
            int key = lotto.getMatchCount(winnerLotto);
            result.put(key, result.getOrDefault(key, DEFAULT_VALUE) + ADD_COUNT);
        }
        return result;
    }

    private static void validate(List<Lotto> buyingLottos, Lotto winnerLotto) {
        Objects.requireNonNull(buyingLottos, "구매한 로또를 올바르게 입력해주세요. input is null");
        Objects.requireNonNull(winnerLotto, "당첨 로또를 올바르게 입력해주세요. input is null");
    }
}
