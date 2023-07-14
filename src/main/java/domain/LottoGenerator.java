package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {

    private static final Money MONEY_UNIT = new Money(1_000L);

    private LottoGenerator() {
    }

    public static List<Lotto> generateLottos(final Money money,
        final Count manualPurchaseCount, final List<List<Integer>> numberBundles) {
        validateMoney(money);
        final Count totalPurchaseCount = calculateLottoPurchaseCount(money);

        validateManualPurchaseCount(manualPurchaseCount, totalPurchaseCount);
        final Count autoPurchaseCount = totalPurchaseCount.decreaseBy(manualPurchaseCount);

        return combine(generateLottosManually(manualPurchaseCount, numberBundles),
            generateLottosAutomatically(autoPurchaseCount));
    }

    private static List<Lotto> generateLottosManually(final Count manualPurchaseCount,
        final List<List<Integer>> numberBundles) {
        validateNumberBundlesCount(numberBundles, manualPurchaseCount);
        return numberBundles.stream()
            .map(Lotto::new)
            .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> generateLottosAutomatically(Count autoPurchaseCount) {
        final List<Lotto> lottos = new ArrayList<>();
        while (autoPurchaseCount.isPositive()) {
            lottos.add(generateSingleLottoAutomatically());
            autoPurchaseCount = autoPurchaseCount.decreaseByOne();
        }
        return lottos.stream()
            .collect(Collectors.toUnmodifiableList());
    }

    private static List<Lotto> combine(final List<Lotto> lottos, final List<Lotto> otherLottos) {
        final List<Lotto> result = new ArrayList<>();
        result.addAll(lottos);
        result.addAll(otherLottos);
        return result;
    }

    private static void validateManualPurchaseCount(final Count manualPurchaseCount,
        final Count totalPurchaseCount) {
        if (totalPurchaseCount.isLessThan(manualPurchaseCount)) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수가 구입금액으로 구매 가능한 총 로또 수보다 많습니다.");
        }
    }

    private static void validateNumberBundlesCount(
        final List<List<Integer>> numberBundles, final Count manualPurchaseCount) {
        if (new Count(numberBundles.size()).isNotEqualTo(manualPurchaseCount)) {
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

    private static void validateMoney(final Money money) {
        validateMinimum(money);
        validateUnit(money);
    }

    private static void validateMinimum(final Money money) {
        if (money.isLessThan(MONEY_UNIT)) {
            throw new IllegalArgumentException("구입금액은 적어도 " + MONEY_UNIT + "원 이상이어야 합니다.");
        }
    }

    private static void validateUnit(final Money money) {
        if (!money.isMultipleOf(MONEY_UNIT)) {
            throw new IllegalArgumentException("구입금액은 " + MONEY_UNIT + "원 단위여야 합니다.");
        }
    }

    private static Count calculateLottoPurchaseCount(Money money) {
        return money.calculateMaximumCount(MONEY_UNIT);
    }
}
