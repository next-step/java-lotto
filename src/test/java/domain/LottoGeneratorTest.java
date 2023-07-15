package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    @DisplayName("로또를 일정 수만큼 수동으로 생성하고, 나머지는 자동으로 생성한다.")
    void generateLottosManuallyAndThenAutomatically() {
        /* given */
        final Money money = Money.valueOf(5_000);
        final LottoCount manualPurchaseCount = new LottoCount(2);
        final List<List<Integer>> numberBundles = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12));

        /* when */
        final List<Lotto> lottos = LottoGenerator.generateLottos(money,
            manualPurchaseCount, numberBundles);

        /* then */
        for (int count = 0; count < manualPurchaseCount.getValue(); count++) {
            final Lotto inputLotto = new Lotto(numberBundles.get(count));
            final Lotto outputLotto = lottos.get(count);
            assertThat(inputLotto).isEqualTo(outputLotto);
        }

        assertThat(lottos).hasSize(5);
    }

    @Test
    @DisplayName("수동으로 구매할 로또 수가 구입금액으로 구매 가능한 총 로또 수보다 많으면 IllegalArgumentException을 던진다.")
    void moneyNotSufficient() {
        /* given */
        final Money money = Money.valueOf(1_000);
        final LottoCount manualPurchaseCount = new LottoCount(2);
        final List<List<Integer>> inputNumberBundles = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12));

        /* when & then*/
        assertThatThrownBy(() -> LottoGenerator.generateLottos(money,
            manualPurchaseCount, inputNumberBundles))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 묶음 수가 수동으로 구매할 로또 수와 일치하지 않으면 IllegalArgumentException을 던진다.")
    void manualGenerationCountAndnumberBundlesCountNotEqual() {
        /* given */
        final Money money = Money.valueOf(5_000);
        final LottoCount manualPurchaseCount = new LottoCount(3);
        final List<List<Integer>> inputNumberBundles = List.of(List.of(1, 2, 3, 4, 5, 6),
            List.of(7, 8, 9, 10, 11, 12));

        /* when & then */
        assertThatThrownBy(() -> LottoGenerator.generateLottos(money,
            manualPurchaseCount, inputNumberBundles))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("투입금액이 로또 1장의 가격보다 작으면 IllegalArgumentException을 반환한다.")
    void validateMinimum() {
        /* given */
        final Money money = Money.valueOf(500);
        final LottoCount manualPurchaseCount = new LottoCount(0);
        final List<List<Integer>> inputNumberBundles = Collections.emptyList();

        /* when & then */
        assertThatThrownBy(() -> LottoGenerator.generateLottos(money,
            manualPurchaseCount, inputNumberBundles))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("투입금액이 로또 가격의 배수가 아니면 IllegalArgumentException을 반환한다.")
    void validateUnit() {
        /* given */
        final Money money = Money.valueOf(1_500);
        final LottoCount manualPurchaseCount = new LottoCount(0);
        final List<List<Integer>> inputNumberBundles = Collections.emptyList();

        /* when & then */
        assertThatThrownBy(() -> LottoGenerator.generateLottos(money,
            manualPurchaseCount, inputNumberBundles))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
