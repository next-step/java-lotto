package lotto.domain.publish;

import static lotto.domain.publish.LottoGenerator.MINIMUM_LOTTO_QUANTITY;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 5, 10, 100})
    @DisplayName("로또 구매 개수만큼 로또를 생성한다.")
    void GenerateLottos_PositiveQuantity(final int positiveQuantity) {
        final LottoGenerator lottoMaker = new LottoGenerator(new RandomLottoNumbersPicker());

        assertThat(lottoMaker.generateLottos(positiveQuantity))
                .hasSize(positiveQuantity);
    }

    @Test
    @DisplayName("로또 구매 개수가 최소 구매 개수보다 적은 경우 예외를 던진다.")
    void GenerateLottos_LessThanMinimumQuantity() {
        final LottoGenerator lottoMaker = new LottoGenerator(new RandomLottoNumbersPicker());
        final int quantityLessThanMinimum = MINIMUM_LOTTO_QUANTITY - 1;

        assertThatIllegalArgumentException()
                .isThrownBy(() -> lottoMaker.generateLottos(quantityLessThanMinimum));
    }
}
