package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또를 일정 수만큼 수동으로 생성하고, 나머지는 자동으로 생성한다.")
    void generateLottosManuallyAndThenAutomatically() {
        /* given */
        final int money = 5_000;
        final int manualPurchaseCount = 2;
        final List<List<Integer>> inputNumberBundles = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12));

        /* when */
        final List<Lotto> lottos = LottoGenerator.generateLottosManuallyAndThenAutomatically(money,
            manualPurchaseCount, inputNumberBundles);

        /* then */
        for (int count = 0; count < manualPurchaseCount; count++) {
            final List<Integer> lottoNumbers = lottos.get(count)
                .getLottoNumbers()
                .stream()
                .map(LottoNumber::getValue)
                .collect(Collectors.toList());
            final List<Integer> inputNumbers = inputNumberBundles.get(count);
            assertThat(lottoNumbers).containsExactlyInAnyOrderElementsOf(inputNumbers);
        }
        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("수동으로 구매할 로또 수가 구입금액으로 구매 가능한 총 로또 수보다 많으면 IllegalArgumentException을 던진다.")
    void moneyNotSufficient() {
        /* given */
        final int money = 1_000;
        final int manualPurchaseCount = 2;
        final List<List<Integer>> inputNumberBundles = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12));

        /* when & then*/
        assertThatThrownBy(() -> LottoGenerator.generateLottosManuallyAndThenAutomatically(money,
            manualPurchaseCount, inputNumberBundles))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 묶음 수가 수동으로 구매할 로또 수와 일치하지 않으면 IllegalArgumentException을 던진다.")
    void manualGenerationCountAndnumberBundlesCountNotEqual() {
        /* given */
        final int money = 5_000;
        final int manualPurchaseCount = 3;
        final List<List<Integer>> inputNumberBundles = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12));

        /* when & then */
        assertThatThrownBy(() -> LottoGenerator.generateLottosManuallyAndThenAutomatically(money,
            manualPurchaseCount, inputNumberBundles))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
