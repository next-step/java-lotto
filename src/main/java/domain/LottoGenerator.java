package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MONEY_UNIT = 1_000;
    private static final List<Integer> candidates =
        IntStream.rangeClosed(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
            .boxed()
            .collect(Collectors.toList());

    private LottoGenerator() {
    }

    public static List<Lotto> generateLottosManuallyAndThenAutomatically(final int money,
        final int manualPurchaseCount, final List<List<Integer>> numberBundles) {
        validate(money);
        final int totalPurchaseCount = calculateLottoCount(money);

        validateManualPurchaseCount(manualPurchaseCount, totalPurchaseCount);
        validateNumberBundlesCount(numberBundles, manualPurchaseCount);

        final List<Lotto> lottos = new ArrayList<>();

        for (int count = 0; count < manualPurchaseCount; count++) {
            lottos.add(new Lotto(numberBundles.get(count)));
        }

        final int autoPurchaseCount = totalPurchaseCount - manualPurchaseCount;
        for (int count = 0; count < autoPurchaseCount; count++) {
            lottos.add(generateSingleLottoAutomatically());
        }

        return lottos;
    }

    private static void validateManualPurchaseCount(final int manualPurchaseCount,
        final int totalPurchaseCount) {
        if (totalPurchaseCount < manualPurchaseCount) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 구입금액으로 구매 가능한 총 로또 수보다 많습니다.");
        }
    }

    private static void validateNumberBundlesCount(
        final List<List<Integer>> numberBundles, final int manualPurchaseCount) {
        if (numberBundles.size() != manualPurchaseCount) {
            throw new IllegalArgumentException("숫자 묶음 수가 수동으로 구매할 로또 수와 일치하지 않습니다.");
        }
    }

    private static Lotto generateSingleLottoAutomatically() {
        Collections.shuffle(candidates);
        return new Lotto(candidates.subList(0, Lotto.REQUIRED_LOTTO_NUMBER_COUNT));
    }

    private static void validate(final int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("구입금액은 " + MONEY_UNIT + "원 단위여야 합니다.");
        }
    }

    private static int calculateLottoCount(int money) {
        return money / MONEY_UNIT;
    }
}
