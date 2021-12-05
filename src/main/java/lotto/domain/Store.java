package lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Store {
    private static int FIRST_GAME = 0;
    public static int LOTTO_ONE_GAME_PRICE = 1000;

    public Lotties purchaseLottiesByMoney(Money money, LottoGenerator numberGenerator) {
        int gameCount = money.getValue() / LOTTO_ONE_GAME_PRICE;
        return new Lotties(IntStream.range(FIRST_GAME, gameCount)
                .mapToObj(n -> numberGenerator.publish())
                .collect(Collectors.toList()));
    }

    public Lotties purchaseManualLotto(List<String> lottoPaper) {
        if (lottoPaper.size() == 0) {
            return new Lotties(Collections.EMPTY_LIST);
        }
        return new Lotties(lottoPaper.stream()
                .map(Lotto::from)
                .collect(Collectors.toList()));
    }
}
