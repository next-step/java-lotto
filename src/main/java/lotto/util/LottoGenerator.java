package lotto.util;

import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Comparator.*;
import static java.util.stream.Collectors.*;

public class LottoGenerator {

    private static final int PRICE_PER_LOTTO = 1000;
    private final List<Integer> LOTTO_SET = new ArrayList<>();

    public LottoGenerator() {
        for (int i = 1; i < 46; i++) {
            LOTTO_SET.add(i);
        }
    }

    public List<Integer> generate() {
        Collections.shuffle(LOTTO_SET);
        return LOTTO_SET.subList(0, 6)
                .stream()
                .sorted(naturalOrder())
                .collect(toList());
    }

    public List<Lotto> generate(int purchaseAmount) {
        int lottoCount = calculatePurchasableCount(purchaseAmount);
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Collections.shuffle(LOTTO_SET);

            lotteries.add(LOTTO_SET
                    .subList(0, 6)
                    .stream()
                    .sorted(naturalOrder())
                    .collect(collectingAndThen(toList(), Lotto::new)));
        }
        return lotteries;
    }

    private int calculatePurchasableCount(int purchaseAmount) {
        return purchaseAmount / PRICE_PER_LOTTO;
    }

}
