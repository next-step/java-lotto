package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final int MONEY_UNIT = 1_000;

    private LottoGenerator() {
    }

    public static List<Lotto> generateLottosManuallyAndThenAutomatically(final int money,
        final int manualPurchaseCount, final List<List<Integer>> numberBundles) {
        validateMoneyUnit(money);
        final int totalPurchaseCount = calculateLottoPurchaseCount(money);

        validateManualPurchaseCount(manualPurchaseCount, totalPurchaseCount);
        final int autoPurchaseCount = totalPurchaseCount - manualPurchaseCount;

        validateNumberBundlesCount(numberBundles, manualPurchaseCount);
        return combine(generateLottosManually(manualPurchaseCount, numberBundles), generateLottosAutomatically(autoPurchaseCount));
    }

    private static List<Lotto> generateLottosManually(final int manualPurchaseCount,
        final List<List<Integer>> numberBundles) {
        return IntStream.range(0, manualPurchaseCount)
            .mapToObj(numberBundles::get)
            .map(Lotto::new)
            .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> generateLottosAutomatically(final int autoPurchaseCount) {
        return IntStream.range(0, autoPurchaseCount)
            .mapToObj(count -> generateSingleLottoAutomatically())
            .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> combine(final List<Lotto> lottos, final List<Lotto> otherLottos) {
        final List<Lotto> result = new ArrayList<>();
        result.addAll(lottos);
        result.addAll(otherLottos);
        return result;
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
        final List<Integer> candidates = generateLottoNumberValueCandidates();
        Collections.shuffle(candidates);
        return new Lotto(candidates.subList(0, Lotto.REQUIRED_LOTTO_NUMBER_COUNT));
    }

    private static List<Integer> generateLottoNumberValueCandidates() {
        return IntStream.rangeClosed(LottoNumber.LOWER_BOUND, LottoNumber.UPPER_BOUND)
            .boxed()
            .collect(Collectors.toList());
    }

    private static void validateMoneyUnit(final int money) {
        if (money % MONEY_UNIT != 0) {
            throw new IllegalArgumentException("구입금액은 " + MONEY_UNIT + "원 단위여야 합니다.");
        }
    }

    private static int calculateLottoPurchaseCount(int money) {
        return money / MONEY_UNIT;
    }
}
