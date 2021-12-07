package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Store {
    private static final int FIRST_GAME = 0;
    public static final int LOTTO_ONE_GAME_PRICE = 1000;

    public Lotties purchaseLottiesByMoney(Money money, LottoGenerator numberGenerator) {
        int gameCount = money.getValue() / LOTTO_ONE_GAME_PRICE;
        return new Lotties(IntStream.range(FIRST_GAME, gameCount)
                .mapToObj(n -> numberGenerator.publish())
                .collect(toList()));
    }

    public Lotties purchaseManualLotto(List<String> lottoPaper) {
        if (lottoPaper.size() == 0) {
            return new Lotties(Collections.EMPTY_LIST);
        }
        return new Lotties(lottoPaper.stream()
                .map(ManualLottoGenerator::new)
                .map(ManualLottoGenerator::publish)
                .collect(toList()));

    }
}
