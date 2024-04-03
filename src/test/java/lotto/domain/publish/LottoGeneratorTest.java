package lotto.domain.publish;

import static lotto.domain.publish.LottoGenerator.MINIMUM_LOTTO_QUANTITY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100})
    @DisplayName("특정 개수만큼 자동 로또를 생성한다.")
    void GenerateAutoLottos_PositiveQuantity(final int positiveQuantity) {
        final LottoGenerator lottoGenerator = new LottoGenerator(new RandomLottoNumbersPicker());

        assertThat(lottoGenerator.generateAutoLottos(positiveQuantity))
                .hasSize(positiveQuantity);
    }

    @Test
    @DisplayName("자동 로또 개수가 최소 개수보다 적은 경우 예외를 던진다.")
    void GenerateAutoLottos_LessThanMinimumQuantity() {
        final LottoGenerator lottoGenerator = new LottoGenerator(new RandomLottoNumbersPicker());
        final int quantityLessThanMinimum = MINIMUM_LOTTO_QUANTITY - 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoGenerator.generateAutoLottos(quantityLessThanMinimum));
    }

    @Test
    @DisplayName("번호 목록 수만큼 수동 로또를 생성한다.")
    void GenerateManualLottos_ManualNumbers() {
        final LottoGenerator lottoGenerator = new LottoGenerator(new RandomLottoNumbersPicker());
        final List<List<Integer>> manualNumbers = List.of(
                List.of(1, 2, 3, 4, 5, 6),
                List.of(10, 11, 12, 13, 14, 15),
                List.of(1, 4, 17, 31, 40, 45)
        );

        assertThat(lottoGenerator.generateManualLottos(manualNumbers))
                .hasSize(manualNumbers.size());
    }
}
