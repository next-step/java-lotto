package lotto.controller;

import lotto.model.LottoGenerator;
import lotto.model.Lottos;
import lotto.model.Money;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class LottoMarket {

    private LottoMarket() {
        throw new AssertionError();
    }

    public static List<Lottos> buyLottos(Money money, LottoGenerator lottoGenerator) {
        validate(money);
        return getLottos(money, lottoGenerator);
    }

    private static void validate(Money money) {
        Objects.requireNonNull(money, "로또 구매시 지불하는 금액은 null일 수 없습니다.");
    }

    private static List<Lottos> getLottos(Money money, LottoGenerator lottoGenerator) {
        int count = money.getUnitCount();

        List<Lottos> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(lottoGenerator.get());
        }

        return lottos;
    }

    public static Map<Integer, Integer> getLottoStatistics(List<Lottos> buyingLottos, Lottos winnerLottos) {
        validate(buyingLottos, winnerLottos);
        Map<Integer, Integer> result = new HashMap<>();
        for (Lottos lottos : buyingLottos) {
            int key = lottos.getMatchCount(winnerLottos);
            result.put(key, result.getOrDefault(key, 0) + 1);
        }
        return result;
    }

    private static void validate(List<Lottos> buyingLottos, Lottos winnerLottos) {
        Objects.requireNonNull(buyingLottos, "구매한 로또를 올바르게 입력해주세요. input is null");
        Objects.requireNonNull(winnerLottos, "당첨 로또를 올바르게 입력해주세요. input is null");
    }
}
